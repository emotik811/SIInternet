/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.acoes.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "BECA")
public class Beca implements Serializable {
    
    public enum Estado{
        ACEPTADA,
        RECHAZADA,
        EN_ESPERA
    }

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_BECA")
    private Integer idBeca;
    @Basic(optional = false)
    @Column(name = "TIPO")
    private String tipo;
    @Basic(optional = false)
    @Column(name = "ESTADO")
    private Estado estado;
    @Basic(optional = false)
    @Column(name = "FECHA_PETICION")
    @Temporal(TemporalType.DATE)
    private Date fechaPeticion;
    @Column(name = "FECHA_RESOLUCION")
    @Temporal(TemporalType.DATE)
    private Date fechaResolucion;
    @Column(name = "CUANTIA")
    private Integer cuantia;
    @JoinColumn(name = "JOVEN_ID_BENEFICIARIO", referencedColumnName = "ID_BENEFICIARIO")
    @ManyToOne(optional = false)
    private Joven jovenIdBeneficiario;

    public Beca() {
    }

    public Beca(Integer idBeca) {
        this.idBeca = idBeca;
    }

    public Beca(Integer idBeca, String tipo, Estado estado, Date fechaPeticion) {
        this.idBeca = idBeca;
        this.tipo = tipo;
        this.estado = estado;
        this.fechaPeticion = fechaPeticion;
    }
    
        public Beca(Integer idBeca, String tipo, Estado estado, Date fechaPeticion, Joven jovenIdBeneficiario) {
        this.idBeca = idBeca;
        this.tipo = tipo;
        this.estado = estado;
        this.fechaPeticion = fechaPeticion;
        this.jovenIdBeneficiario = jovenIdBeneficiario;
                
    }
    

    public Integer getIdBeca() {
        return idBeca;
    }

    public void setIdBeca(Integer idBeca) {
        this.idBeca = idBeca;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Date getFechaPeticion() {
        return fechaPeticion;
    }

    public void setFechaPeticion(Date fechaPeticion) {
        this.fechaPeticion = fechaPeticion;
    }

    public Date getFechaResolucion() {
        return fechaResolucion;
    }

    public void setFechaResolucion(Date fechaResolucion) {
        this.fechaResolucion = fechaResolucion;
    }

    public Integer getCuantia() {
        return cuantia;
    }

    public void setCuantia(Integer cuantia) {
        this.cuantia = cuantia;
    }

    public Joven getJovenIdBeneficiario() {
        return jovenIdBeneficiario;
    }

    public void setJovenIdBeneficiario(Joven jovenIdBeneficiario) {
        this.jovenIdBeneficiario = jovenIdBeneficiario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBeca != null ? idBeca.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Beca)) {
            return false;
        }
        Beca other = (Beca) object;
        if ((this.idBeca == null && other.idBeca != null) || (this.idBeca != null && !this.idBeca.equals(other.idBeca))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "acoestarea1.entidades.Beca[ idBeca=" + idBeca + " ]";
    }
    
}
