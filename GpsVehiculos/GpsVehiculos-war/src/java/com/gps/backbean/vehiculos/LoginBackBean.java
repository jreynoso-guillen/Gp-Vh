/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gps.backbean.vehiculos;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Kryzpy
 */
@ManagedBean
@SessionScoped
public class LoginBackBean implements Serializable{
    
    //Variables
    private String usuario = "";
    private String contraseña = "";
    
    private String sessionId="";
    
    
    
    
    //Funciones
    public String login() throws UnsupportedEncodingException{
        System.out.println("Entro al Login!!!1");
        
        System.out.println(usuario);
        
        System.out.println(contraseña);
        
        if(usuario.equals("admin")){
            if(contraseña.equals("123")){
                FacesContext fctx = FacesContext.getCurrentInstance();
                ExternalContext ectx = fctx.getExternalContext();
                HttpSession session = (HttpSession) ectx.getSession(false);
                sessionId = session.getId();
                return "index";
                
            }else{
                return "";
            }
        }else{
            return "";
        }
        
    }
    
    public String getSesionAbierta() {
        if (sessionId != null && !sessionId.equals("")) {
            // System.out.println("Entro a abrir pagina");
            
        }
        return "";
    }
    
    public String logout(){
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext ec = context.getExternalContext();
        final HttpServletRequest request = (HttpServletRequest) ec.getRequest();
        context.getExternalContext().getSessionMap().clear();
        request.getSession(false).invalidate();
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
    
    
    
    
}
