/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gps.backbean.vehiculos;

import com.gps.backbean.objectVehiculos.empresaObj;
import com.gps.backbean.objectVehiculos.vehiculoObj;
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
    private List<vehiculoObj> listaVh;
    private vehiculoObj vhT;
    private List<empresaObj> listaEmpresas;
    
    private Vehiculos vhTemp;
    
    private Empresas empTemp;

    public VehiculosBackBean(){
    }
    
    public String cargarVehiculos(){
        System.out.println("Cargando vehiculos");
        listaVehiculos = new ArrayList<>();
        listaVh= new ArrayList<>();
        String xmlConsul=vh.cargaVehiculos();
        XMLTools xml = new XMLTools();
        List<String[]> lista= xml.parseXMLtoListString(xmlConsul, "hijo");
        
        for(int i=0;i<lista.size();i++){
            vehiculoObj temp= new vehiculoObj();
            temp.setId(Integer.parseInt(lista.get(i)[0]));
            temp.setNombre(lista.get(i)[1]);
            SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat formatoDelTexto2 = new SimpleDateFormat("dd-MM-yyy");
            try{
                String fecha=lista.get(i)[2];
                Date fechaD = null;
                fechaD=formatoDelTexto.parse(fecha);
                fecha=formatoDelTexto2.format(fechaD);
                temp.setFechaAltaS(fecha);
                temp.setFechaAlta(fechaD);
            }catch(ParseException e){
                e.printStackTrace();
            }
            
            temp.setPlataforma(lista.get(i)[3]);
            temp.setIMEI(lista.get(i)[4]);
            temp.setNumeroTelefono(Integer.parseInt(lista.get(i)[5]));
            temp.setClave(Integer.parseInt(lista.get(i)[6]));
            temp.setSaldo(lista.get(i)[7]);
            try{
                String fecha=lista.get(i)[8];
                Date fechaD = null;
                fechaD=formatoDelTexto.parse(fecha);
                fecha=formatoDelTexto2.format(fechaD);
                temp.setFechaVenceS(fecha);
                fechaD=formatoDelTexto.parse(fecha);
                
                temp.setFechaVence(fechaD);;
            }catch(ParseException e){
                e.printStackTrace();
            }
            temp.setTipoCobro(lista.get(i)[9]);
            temp.setCuenta(lista.get(i)[10]);
            temp.setMarca(lista.get(i)[11]);
            temp.setModelo(lista.get(i)[12]);
            temp.setAn(lista.get(i)[13]);
            temp.setPlaca(lista.get(i)[14]);
            temp.setSerie(lista.get(i)[15]);
            temp.setMotor(lista.get(i)[16]);
            Empresas nombreEmpresa=vh.buscaEmpresa(Integer.parseInt(lista.get(i)[17]));
            temp.setEmpresa(nombreEmpresa.getIdempresa()+"");
            if(lista.get(i)[18].equals("1")){
                temp.setStatus(true);
            }else{
                temp.setStatus(false);
            }
            
            listaVh.add(temp);
        }
        xmlConsul=vh.cargaEmpresas();
        xml = new XMLTools();
        lista= xml.parseXMLtoListString(xmlConsul, "hijo");
        listaEmpresas= new ArrayList<>();
        for(int i=0;i<lista.size();i++){
            empresaObj e= new empresaObj();
            e.setId(Integer.parseInt(lista.get(i)[0]));
            e.setNombre(lista.get(i)[1]);
            listaEmpresas.add(e);
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
    
    
    public void modificaVh(vehiculoObj obj){
        
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

    public List<vehiculoObj> getListaVh() {
        return listaVh;
    }

    public void setListaVh(List<vehiculoObj> listaVh) {
        this.listaVh = listaVh;
    }

    public vehiculoObj getVhT() {
        return vhT;
    }

    public void setVhT(vehiculoObj vhT) {
        this.vhT = vhT;
    }

    public AdmVehiculosFacadeLocal getVh() {
        return vh;
    }

    public void setVh(AdmVehiculosFacadeLocal vh) {
        this.vh = vh;
    }

    public List<empresaObj> getListaEmpresas() {
        return listaEmpresas;
    }

    public void setListaEmpresas(List<empresaObj> listaEmpresas) {
        this.listaEmpresas = listaEmpresas;
    }

  
    
    
    
}
