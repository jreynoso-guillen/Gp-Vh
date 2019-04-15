/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gps.backbean.vehiculos;

import com.gps.ejb.facades.AdmVehiculosFacade;
import com.gps.ejb.facades.AdmVehiculosFacadeLocal;
import com.gps.ejb.utilerias.XMLTools;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Kryzpy
 */
@SessionScoped
@ManagedBean
public class LoginBackBean implements Serializable{
    
    //Variables
    private String usuario = "";
    private String contraseña = "";
    
    private String sessionId="";
    private int idUsuario;
    
    @EJB
    private AdmVehiculosFacadeLocal vh;  
    
    public LoginBackBean(){
    }
    
    //Accede a los beans
    
    public EmpresasBackBean getEmpresasBackBean(){
        String backBeanName="EmpresasBackBean";
        EmpresasBackBean eb = (EmpresasBackBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(backBeanName);
        if(eb == null){
            eb = new EmpresasBackBean();
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(backBeanName,eb);
        }
        return (EmpresasBackBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(backBeanName);
                
    }
    
    //Funciones
    public String login() throws UnsupportedEncodingException{
        
        
        String xmlConsul=vh.login(usuario, contraseña);
        XMLTools xml = new XMLTools();
        List<String[]> lista= xml.parseXMLtoListString(xmlConsul, "hijo");
        
        if(lista.size()>0){
            //si encontro al usuario y la contraseña
            idUsuario=Integer.parseInt(lista.get(0)[0]);
            System.out.println("usuarioId="+idUsuario);
            System.out.println(idUsuario+"--idusuario");
            FacesContext fctx = FacesContext.getCurrentInstance();
            ExternalContext ectx = fctx.getExternalContext();
            HttpSession session = (HttpSession) ectx.getSession(false);
            session.setAttribute("sessionId", session.getId());
            session.setAttribute("idUsuario", idUsuario);
            
        }else{
            FacesMessage message = new FacesMessage(" Usuario o contraseña no valido. " );
            FacesContext.getCurrentInstance().addMessage(null, message);
            return "login";
        }
        
        return "index";
        
    }
    
    public String getSesionAbierta() {
        if (sessionId != null && !sessionId.equals("")) {
            // System.out.println("Entro a abrir pagina");
            
        }
        return "";
    }
    
    public String logout(){
        /*FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext ec = context.getExternalContext();
        final HttpServletRequest request = (HttpServletRequest) ec.getRequest();
        context.getExternalContext().getSessionMap().clear();
        request.getSession(false).invalidate();*/
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "login";
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
    
    
    
    
}
