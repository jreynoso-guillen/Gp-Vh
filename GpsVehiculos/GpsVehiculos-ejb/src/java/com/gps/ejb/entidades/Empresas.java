/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gps.ejb.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author Kryzpy
 */
@Entity
@Table(name = "empresas")
@NamedQueries({
    @NamedQuery(name = "Empresas.findAll", query = "SELECT e FROM Empresas e")})
public class Empresas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDEMPRESA")
    private Integer idempresa;
    @Size(max = 255)
    @Column(name = "NOMBREEMPRESA")
    private String nombreempresa;
    @Size(max = 255)
    @Column(name = "NOMBRECONTACTO")
    private String nombrecontacto;
    @Size(max = 55)
    @Column(name = "TELCONTACTO")
    private String telcontacto;
    @Size(max = 55)
    @Column(name = "CORREO")
    private String correo;
    @Size(max = 20)
    @Column(name = "RFC")
    private String rfc;
    @Size(max = 255)
    @Column(name = "DIRECCION")
    private String direccion;

    public Empresas() {
    }

    public Empresas(Integer idempresa) {
        this.idempresa = idempresa;
    }

    public Integer getIdempresa() {
        return idempresa;
    }

    public void setIdempresa(Integer idempresa) {
        this.idempresa = idempresa;
    }

    public String getNombreempresa() {
        return nombreempresa;
    }

    public void setNombreempresa(String nombreempresa) {
        this.nombreempresa = nombreempresa;
    }

    public String getNombrecontacto() {
        return nombrecontacto;
    }

    public void setNombrecontacto(String nombrecontacto) {
        this.nombrecontacto = nombrecontacto;
    }

    public String getTelcontacto() {
        return telcontacto;
    }

    public void setTelcontacto(String telcontacto) {
        this.telcontacto = telcontacto;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idempresa != null ? idempresa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empresas)) {
            return false;
        }
        Empresas other = (Empresas) object;
        if ((this.idempresa == null && other.idempresa != null) || (this.idempresa != null && !this.idempresa.equals(other.idempresa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gps.ejb.entidades.Empresas[ idempresa=" + idempresa + " ]";
    }
    
}
