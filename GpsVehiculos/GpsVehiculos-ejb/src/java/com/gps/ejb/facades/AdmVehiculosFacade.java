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
import java.util.List;
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
            String sql="SELECT * FROM `vehiculos` v ORDER BY v.`STATUS`=1 DESC ";
            
            return XMLTools.xmlQueryBase(sql, "base", "hijo");
        }
        
        public Empresas buscaEmpresa(int id){
            Empresas e= em.find(Empresas.class, id);
            
            return e;
        }
        
        public String modifica(Vehiculos v){
            Vehiculos vh= new Vehiculos();
            vh= em.find(Vehiculos.class, v.getIdvehiculo());
            
            if(vh!=null){
                vh.setStatus(v.getStatus());
                vh.setSaldo(v.getSaldo());
                vh.setPagado(v.getPagado());
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
        
        public boolean validaImei(String i){
            System.out.println("Validando IMEI");
            Boolean r= true;
            String sql="SELECT * FROM `vehiculos` v WHERE v.`IMEI` ='"+i+"'";
            String re=XMLTools.xmlQueryBase(sql, "base", "hijo");
            
            XMLTools xml = new XMLTools();
            List<String[]> lista= xml.parseXMLtoListString(re, "hijo");
            
            if(lista.size()>0)
                r=false;
            
            
            
            return r;
        }
        
        public boolean validaTelefono(String i){
            Boolean r= true;
            String sql="SELECT * FROM `vehiculos` v WHERE v.`NUMEROTELEFONICO` ='"+i+"'";
            String re=XMLTools.xmlQueryBase(sql, "base", "hijo");
            
            XMLTools xml = new XMLTools();
            List<String[]> lista= xml.parseXMLtoListString(re, "hijo");
            
            if(lista.size()>0)
                r=false;
            
            
            
            return r;
        }
    
}
