/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gps.backbean.vehiculos;

import com.gps.ejb.facades.AdmVehiculosFacadeLocal;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.enterprise.context.SessionScoped;
import javax.inject.Scope;

/**
 *
 * @author Kryzpy
 */
@ManagedBean
@SessionScoped
public class VehiculosBackBean implements Serializable{
    
    //variables
    private String var="Hola mundopz ya";
    @EJB
    private AdmVehiculosFacadeLocal corridasFacade;

    //funcinones
    public void inicio(){
        System.out.println("Entro");
        
        
        String prueba = corridasFacade.HolaMundo();
        
        System.out.println("Salio");
        
    }
    //set y gets

    public String getVar() {
        return var;
    }

    public void setVar(String var) {
        this.var = var;
    }
    
}
