/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gps.backbean.vehiculos;

import com.gps.ejb.entidades.Empresas;
import com.gps.ejb.facades.AdmVehiculosFacadeLocal;
import com.gps.ejb.utilerias.XMLTools;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.component.behavior.FacesBehavior;
import javax.faces.context.FacesContext;

/**
 *
 * @author Kryzpy
 */
@SessionScoped
@ManagedBean
public class EmpresasBackBean implements Serializable{
    
    private List<Empresas> listaEmpresas=null;
    @EJB
    private AdmVehiculosFacadeLocal vh;
    
    public EmpresasBackBean (){
        
    }
    
    private LoginBackBean sesion(){
        return (LoginBackBean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("LoginBackBean");
    }
    
    private LoginBackBean session() {
        return (LoginBackBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("LoginBackBean");
    }
    
    public String cargarEmpresas(){
        
        /*if(session().getIdUsuario()<=0){
            FacesContext facesContext = FacesContext.getCurrentInstance();
            FacesMessage facesMessage = new FacesMessage("Inicie sesion por favor");
            facesContext.addMessage(null, facesMessage);
            return "login";
        }*/
        try{
            System.out.println("---sessionIdDe Nuevi"+session().getSessionId());
        }catch(Exception e){
            System.out.println(e);
        }
        
        
        
        String xmlConsul=vh.cargaEmpresas();
        XMLTools xml = new XMLTools();
        List<String[]> lista= xml.parseXMLtoListString(xmlConsul, "hijo");
        listaEmpresas= new ArrayList<>();
        for(int i=0; i<lista.size();i++){
            Empresas aux= new Empresas();
            aux.setIdempresa(Integer.parseInt(lista.get(i)[0]));
            aux.setNombreempresa(lista.get(i)[1]);
            aux.setNombrecontacto(lista.get(i)[2]);
            aux.setTelcontacto(lista.get(i)[3]);
            aux.setCorreo(lista.get(i)[4]);
            listaEmpresas.add(aux);
        }
        
        return "empresas";
        
        
    }

    public List<Empresas> getListaEmpresas() {
        return listaEmpresas;
    }

    public void setListaEmpresas(List<Empresas> listaEmpresas) {
        this.listaEmpresas = listaEmpresas;
    }
    
    
    
}
