/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gps.backbean.objectVehiculos;

import java.util.Date;

/**
 *
 * @author toño
 */
public class vehiculoObj {
    private int id;
    private String nombre;
    private Date fechaAlta;
    private String fechaAltaS;
    private String plataforma;
    private String IMEI;
    private String numeroTelefono;
    private String clave; 
    private String saldo;
    private Date fechaVence;
    private String fechaVenceS;
    private String tipoCobro;
    private String cuenta;
    private String marca;
    private String modelo;
    private String an;
    private String placa;
    private String serie;
    private String motor;
    private int empresa;
    private boolean status;
    private String status2;
    private String gpsMarca;
    private boolean pagado;
    private String colaborador;
    
    public vehiculoObj(){
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

   

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public String getIMEI() {
        return IMEI;
    }

    public void setIMEI(String IMEI) {
        this.IMEI = IMEI;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getSaldo() {
        return saldo;
    }

    public void setSaldo(String saldo) {
        this.saldo = saldo;
    }

  

    public String getTipoCobro() {
        return tipoCobro;
    }

    public void setTipoCobro(String tipoCobro) {
        this.tipoCobro = tipoCobro;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getAn() {
        return an;
    }

    public void setAn(String an) {
        this.an = an;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    public int getEmpresa() {
        return empresa;
    }

    public void setEmpresa(int empresa) {
        this.empresa = empresa;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public Date getFechaVence() {
        return fechaVence;
    }

    public void setFechaVence(Date fechaVence) {
        this.fechaVence = fechaVence;
    }

    public String getFechaAltaS() {
        return fechaAltaS;
    }

    public void setFechaAltaS(String fechaAltaS) {
        this.fechaAltaS = fechaAltaS;
    }

    public String getFechaVenceS() {
        return fechaVenceS;
    }

    public void setFechaVenceS(String fechaVenceS) {
        this.fechaVenceS = fechaVenceS;
    }

    public String getGpsMarca() {
        return gpsMarca;
    }

    public void setGpsMarca(String gpsMarca) {
        this.gpsMarca = gpsMarca;
    }

    public boolean isPagado() {
        return pagado;
    }

    public void setPagado(boolean pagado) {
        this.pagado = pagado;
    }

    public String getColaborador() {
        return colaborador;
    }

    public void setColaborador(String colaborador) {
        this.colaborador = colaborador;
    }

    public String getStatus2() {
        return status2;
    }

    public void setStatus2(String status2) {
        this.status2 = status2;
    }
    
    
    
}
