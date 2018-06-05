/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gps.ejb.facades;

import com.gps.ebj.entidades.Empresas;
import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Kryzpy
 */

@Stateless
public class AdmVehiculosFacade implements AdmVehiculosFacadeLocal{
    
    @PersistenceContext(unitName = "GpsVehiculos-PU")
    private EntityManager em;
    @Resource
    SessionContext ctx;
    
    
        public String HolaMundo(){
            System.out.println("Esta vivo!!!!");
            Empresas e = new Empresas();
            e.setNombreempresa("EVOTI");
            e.setNombrecontacto("Miguel padilla");
            e.setTelcontacto("4432426583");
            e.setCorreo("jreynoso@software.ti");
            em.persist(e);
            
            //em.remove(e);
        return "Hola Mundo desde el facade";
    }
    
}
