/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gps.backbean.vehiculos;

import com.gps.ejb.entidades.Empresas;
import com.gps.ejb.entidades.Vehiculos;
import com.gps.ejb.facades.AdmVehiculosFacadeLocal;
import com.gps.ejb.utilerias.XMLTools;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Scope;

/**
 *
 * @author Kryzpy
 */
@ManagedBean
@SessionScoped
public class VehiculosBackBean implements Serializable{
    
    //variables
    @EJB
    private AdmVehiculosFacadeLocal vh;
    
    private List<Vehiculos> listaVehiculos;
    
    private Vehiculos vhTemp;
    
    private Empresas empTemp;

    public VehiculosBackBean(){
    }
    
    public String cargarVehiculos(){
        System.out.println("Cargando vehiculos");
        listaVehiculos = new ArrayList<>();
        String xmlConsul=vh.cargaVehiculos();
        XMLTools xml = new XMLTools();
        List<String[]> lista= xml.parseXMLtoListString(xmlConsul, "hijo");
        
        for(int i=0;i<lista.size();i++){
            Vehiculos temp= new Vehiculos();
            temp.setIdvehiculo(Integer.parseInt(lista.get(i)[0]));
            temp.setNombrevehiculo(lista.get(i)[1]);
            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            try{
                Date date =formatter.parse(lista.get(i)[2]);
                temp.setFechaalta(date);
                
            }catch(ParseException e){
                e.printStackTrace();
            }
            
            temp.setPlataforma(lista.get(i)[3]);
            temp.setImei(lista.get(i)[4]);
            temp.setNumerotelefonico(Integer.parseInt(lista.get(i)[5]));
            temp.setClave(Integer.parseInt(lista.get(i)[6]));
            temp.setSaldo(lista.get(i)[7]);
            try{
                Date date = formatter.parse(lista.get(i)[2]);
                temp.setFechavencimiento(date);
            }catch(ParseException e){
                e.printStackTrace();
            }
            temp.setTipodecobro(lista.get(i)[9]);
            temp.setCuentatelcel(lista.get(i)[10]);
            temp.setMarca(lista.get(i)[11]);
            temp.setModelo(lista.get(i)[12]);
            temp.setAn(lista.get(i)[13]);
            temp.setPlaca(lista.get(i)[14]);
            temp.setSerie(lista.get(i)[15]);
            temp.setMotor(lista.get(i)[16]);
            temp.setIdempresa(Integer.parseInt(lista.get(i)[17]));
            
            listaVehiculos.add(temp);
        }
        
        return "vehiculos";
        
    }
    
    public void datosEmpresa(String id){
        empTemp= new Empresas();
        empTemp=vh.buscaEmpresa(Integer.parseInt(id));
    } 
    
    public void agregarNuevoVh(){
        vhTemp= new Vehiculos();
    }
    
    

   
    
    //funcinones
    //set y gets

    public List<Vehiculos> getListaVehiculos() {
        return listaVehiculos;
    }

    public void setListaVehiculos(List<Vehiculos> listaVehiculos) {
        this.listaVehiculos = listaVehiculos;
    }

     public Vehiculos getVhTemp() {
        return vhTemp;
    }

    public void setVhTemp(Vehiculos vhTemp) {
        this.vhTemp = vhTemp;
    }

    public Empresas getEmpTemp() {
        return empTemp;
    }

    public void setEmpTemp(Empresas empTemp) {
        this.empTemp = empTemp;
    }
    
    
    
}
