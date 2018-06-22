/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gps.ejb.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Kryzpy
 */
@Entity
@Table(name = "vehiculos")
@NamedQueries({
    @NamedQuery(name = "Vehiculos.findAll", query = "SELECT v FROM Vehiculos v")})
public class Vehiculos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDVEHICULO")
    private Integer idvehiculo;
    @Size(max = 255)
    @Column(name = "NOMBREVEHICULO")
    private String nombrevehiculo;
    @Column(name = "FECHAALTA")
    @Temporal(TemporalType.DATE)
    private Date fechaalta;
    @Size(max = 255)
    @Column(name = "PLATAFORMA")
    private String plataforma;
    @Size(max = 255)
    @Column(name = "IMEI")
    private String imei;
    @Column(name = "NUMEROTELEFONICO")
    private Integer numerotelefonico;
    @Column(name = "CLAVE")
    private Integer clave;
    @Size(max = 55)
    @Column(name = "SALDO")
    private String saldo;
    @Column(name = "FECHAVENCIMIENTO")
    @Temporal(TemporalType.DATE)
    private Date fechavencimiento;
    @Size(max = 55)
    @Column(name = "TIPODECOBRO")
    private String tipodecobro;
    @Size(max = 55)
    @Column(name = "CUENTATELCEL")
    private String cuentatelcel;
    @Size(max = 55)
    @Column(name = "MARCA")
    private String marca;
    @Size(max = 55)
    @Column(name = "MODELO")
    private String modelo;
    @Size(max = 55)
    @Column(name = "AN")
    private String an;
    @Size(max = 55)
    @Column(name = "PLACA")
    private String placa;
    @Size(max = 55)
    @Column(name = "SERIE")
    private String serie;
    @Size(max = 55)
    @Column(name = "MOTOR")
    private String motor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDEMPRESA")
    private int idempresa;
    @Column(name = "STATUS")
    private Boolean status;

    public Vehiculos() {
    }

    public Vehiculos(Integer idvehiculo) {
        this.idvehiculo = idvehiculo;
    }

    public Vehiculos(Integer idvehiculo, int idempresa) {
        this.idvehiculo = idvehiculo;
        this.idempresa = idempresa;
    }

    public Integer getIdvehiculo() {
        return idvehiculo;
    }

    public void setIdvehiculo(Integer idvehiculo) {
        this.idvehiculo = idvehiculo;
    }

    public String getNombrevehiculo() {
        return nombrevehiculo;
    }

    public void setNombrevehiculo(String nombrevehiculo) {
        this.nombrevehiculo = nombrevehiculo;
    }

    public Date getFechaalta() {
        return fechaalta;
    }

    public void setFechaalta(Date fechaalta) {
        this.fechaalta = fechaalta;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public Integer getNumerotelefonico() {
        return numerotelefonico;
    }

    public void setNumerotelefonico(Integer numerotelefonico) {
        this.numerotelefonico = numerotelefonico;
    }

    public Integer getClave() {
        return clave;
    }

    public void setClave(Integer clave) {
        this.clave = clave;
    }

    public String getSaldo() {
        return saldo;
    }

    public void setSaldo(String saldo) {
        this.saldo = saldo;
    }

    public Date getFechavencimiento() {
        return fechavencimiento;
    }

    public void setFechavencimiento(Date fechavencimiento) {
        this.fechavencimiento = fechavencimiento;
    }

    public String getTipodecobro() {
        return tipodecobro;
    }

    public void setTipodecobro(String tipodecobro) {
        this.tipodecobro = tipodecobro;
    }

    public String getCuentatelcel() {
        return cuentatelcel;
    }

    public void setCuentatelcel(String cuentatelcel) {
        this.cuentatelcel = cuentatelcel;
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

    public int getIdempresa() {
        return idempresa;
    }

    public void setIdempresa(int idempresa) {
        this.idempresa = idempresa;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idvehiculo != null ? idvehiculo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vehiculos)) {
            return false;
        }
        Vehiculos other = (Vehiculos) object;
        if ((this.idvehiculo == null && other.idvehiculo != null) || (this.idvehiculo != null && !this.idvehiculo.equals(other.idvehiculo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gps.ejb.entidades.Vehiculos[ idvehiculo=" + idvehiculo + " ]";
    }
    
}
