/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gps.ejb.facades;

import com.gps.ejb.entidades.Empresas;
import com.gps.ejb.entidades.Usuarios;
import com.gps.ejb.utilerias.XMLTools;
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
            //comentario cualquiera
            em.persist(e);
            
            //em.remove(e);
        return "Hola Mundo desde el facade";
    }
        
        public String login(String u, String c){
            String regresa="";
            Usuarios usu = new Usuarios();
            
            String sql="SELECT * FROM `usuarios` u WHERE u.`USUAIO`="+u+" AND pass='"+c+"'";
            
            return XMLTools.xmlQueryBase(sql, "base", "hijo");
        }
        
        public String cargaEmpresas(){
            String sql="SELECT * FROM `empresas` e";
            return XMLTools.xmlQueryBase(sql, "base", "hijo");
            
        }
    
}
