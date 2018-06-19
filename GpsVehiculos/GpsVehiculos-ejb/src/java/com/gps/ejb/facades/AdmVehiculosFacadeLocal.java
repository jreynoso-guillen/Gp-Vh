/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gps.ejb.facades;

import com.gps.ejb.entidades.Empresas;
import javax.ejb.Local;

/**
 *
 * @author Kryzpy
 */
@Local
public interface AdmVehiculosFacadeLocal {
    
    String HolaMundo();
    
    public String login(String u, String c);
    
    public String cargaEmpresas();
    
    public String guardarEmpresas(Empresas e);
    
    public String eliminarEmpresa(String id);
    
}
