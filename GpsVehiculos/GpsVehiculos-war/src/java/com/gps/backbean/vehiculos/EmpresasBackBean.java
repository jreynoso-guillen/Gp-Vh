/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gps.backbean.vehiculos;

import com.gps.backbean.objectVehiculos.empresaObj;
import com.gps.ejb.entidades.Empresas;
import com.gps.ejb.facades.AdmVehiculosFacadeLocal;
import com.gps.ejb.utilerias.XMLTools;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.behavior.FacesBehavior;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Kryzpy
 */
@SessionScoped
@ManagedBean
public class EmpresasBackBean implements Serializable{
    
    private List<Empresas> listaEmpresas;
    @EJB
    private AdmVehiculosFacadeLocal vh;
    
    private String s="";
    
    private empresaObj tempEmpresa=null;
    
    public EmpresasBackBean (){
        
    }
    
    
    
    public String cargarEmpresas(){
        
        FacesContext fctx = FacesContext.getCurrentInstance();
        ExternalContext ectx = fctx.getExternalContext();
        HttpSession session = (HttpSession) ectx.getSession(false);
        
        String usr=session.getAttribute("sessionId").toString();
        s=usr;
        
        System.out.println("cargando empresas"+s);
        String xmlConsul=vh.cargaEmpresas();
        XMLTools xml = new XMLTools();
        List<String[]> lista= xml.parseXMLtoListString(xmlConsul, "hijo");
        listaEmpresas= new ArrayList<>();
        for(int i=0; i<lista.size();i++){
            System.out.println("Recporriendo");
            Empresas aux= new Empresas();
            aux.setIdempresa(Integer.parseInt(lista.get(i)[0]));
            aux.setNombreempresa(lista.get(i)[1]);
            aux.setNombrecontacto(lista.get(i)[2]);
            aux.setTelcontacto(lista.get(i)[3]);
            aux.setCorreo(lista.get(i)[4]);
            listaEmpresas.add(aux);
        }
        System.out.println("++++"+listaEmpresas.size());
        System.out.println("Cargo empresas");
        return "empresas";
        
        
    }
    
    public void nuevaEmpresaAgregar(){
        tempEmpresa= new empresaObj();
    }
    
    public void guardarEmpresa(){
        System.out.println("guardando");
        Empresas e= new Empresas();
        e.setNombreempresa(tempEmpresa.getNombre());
        e.setNombrecontacto(tempEmpresa.getContacto());
        e.setTelcontacto(tempEmpresa.getTelefono());
        e.setCorreo(tempEmpresa.getCorreo());
        String resul=vh.guardarEmpresas(e);
        if(resul.equals("error")){
        }else{
            e.setIdempresa(Integer.parseInt(resul));
            listaEmpresas.add(e);
        }
        tempEmpresa=null;
        FacesMessage message = new FacesMessage(" Nueva empresa agregada " );
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
    public void EliminarEmpresa(String id){
        System.out.println("eliminando");
        String resul=vh.eliminarEmpresa(id);
        if(resul.equals("error")){
            FacesMessage message = new FacesMessage(" Ocurrio un error al eliminar la empresa, puede que este asignada a un vehiculo " );
            FacesContext.getCurrentInstance().addMessage(null, message);
        }else{
            
        FacesMessage message = new FacesMessage(" Nueva empresa agregada " );
        FacesContext.getCurrentInstance().addMessage(null, message);
        
        cargarEmpresas();
        }
    }
    
    public String regresa(){
        return "login";
    }

    public List<Empresas> getListaEmpresas() {
        return listaEmpresas;
    }

    public void setListaEmpresas(List<Empresas> listaEmpresas) {
        this.listaEmpresas = listaEmpresas;
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }


    public empresaObj getTempEmpresa() {
        return tempEmpresa;
    }

    public void setTempEmpresa(empresaObj tempEmpresa) {
        this.tempEmpresa = tempEmpresa;
    }

    

   
    
    
    
}
