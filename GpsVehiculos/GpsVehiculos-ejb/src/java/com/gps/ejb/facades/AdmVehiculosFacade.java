/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gps.ejb.facades;

import com.gps.ejb.entidades.Empresas;
import com.gps.ejb.entidades.Usuarios;
import com.gps.ejb.entidades.Vehiculos;
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
            
            String sql="SELECT * FROM `usuarios` u WHERE u.`USUAIO`='"+u+"' AND pass='"+c+"'";
            
            return XMLTools.xmlQueryBase(sql, "base", "hijo");
        }
        
        public String cargaEmpresas(){
            String sql="SELECT * FROM `empresas` e";
            return XMLTools.xmlQueryBase(sql, "base", "hijo");
            
        }
        
        public String guardarEmpresas(Empresas e){
            try{
                em.persist(e);
                em.flush();
            }catch(Exception r){
                return "error";
            }
            
            return e.getIdempresa()+"";
        }
        
        public String eliminarEmpresa(String id){
            try{
                System.out.println("---si eliminando"+id);
                Empresas emp = em.find(Empresas.class, Integer.parseInt(id));
                em.remove(emp);
                em.flush();
                return "";
            }catch(Exception e){
                System.out.println(e);
                return "error";
            }
        }
        
        public String cargaVehiculos(){
            String sql="SELECT * FROM `vehiculos`";
            
            return XMLTools.xmlQueryBase(sql, "base", "hijo");
        }
        
        public Empresas buscaEmpresa(int id){
            Empresas e= em.find(Empresas.class, id);
            
            return e;
        }
        
        public String modifica(Vehiculos v){
            System.out.println("segundo");
            Vehiculos vh= new Vehiculos();
            vh= em.find(Vehiculos.class, v.getIdvehiculo());
            
            if(vh!=null){
                vh.setStatus(v.getStatus());
                vh.setSaldo(v.getSaldo());
                vh.setFechavencimiento(v.getFechavencimiento());
                em.merge(vh);
                em.flush();
                return"exito";
            }else{
                return "error";
            }
            
            
        }
        
        public String guardaVh(Vehiculos v){
            
            try{
                em.persist(v);
                em.flush();
                return v.getIdvehiculo()+" "+v.getNombrevehiculo();
            }catch(Exception e){
                return "error";
            }
            
            
            
        }
    
}
