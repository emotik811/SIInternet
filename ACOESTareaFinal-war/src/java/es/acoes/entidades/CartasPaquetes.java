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
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "CARTAS_PAQUETES")
public class CartasPaquetes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_ENV\u00cdO")
    private Integer idEnvío;
    @Basic(optional = false)
    @Column(name = "FECHA_ENVIO")
    @Temporal(TemporalType.DATE)
    private Date fechaEnvio;
    @Basic(optional = false)
    @Column(name = "CONTENIDO")
    private String contenido;
    @Column(name = "FECHA_RECEPCION")
    @Temporal(TemporalType.DATE)
    private Date fechaRecepcion;
    @JoinColumns({
        @JoinColumn(name = "APADRINAMIENTO_SOCIO_DNI", referencedColumnName = "SOCIO_DNI")
        , @JoinColumn(name = "APADRINAMIENTO_JOVEN_ID_BENEFICIARIO", referencedColumnName = "JOVEN_ID_BENEFICIARIO")})
    @ManyToOne(optional = false)
    private Apadrinamiento apadrinamiento;

    public CartasPaquetes() {
        
    }
    
    public CartasPaquetes(Integer idEnvío, String contenido, Date fechaEnvio,Apadrinamiento apadrinamiento ){
        
             this.idEnvío = idEnvío;
             this.contenido = contenido;
             this.fechaEnvio = fechaEnvio;
             this.apadrinamiento = apadrinamiento;
        
    }


    public Integer getIdEnvío() {
        return idEnvío;
    }

    public void setIdEnvío(Integer idEnvío) {
        this.idEnvío = idEnvío;
    }

    public Date getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(Date fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Date getFechaRecepcion() {
        return fechaRecepcion;
    }

    public void setFechaRecepcion(Date fechaRecepcion) {
        this.fechaRecepcion = fechaRecepcion;
    }

    public Apadrinamiento getApadrinamiento() {
        return apadrinamiento;
    }

    public void setApadrinamiento(Apadrinamiento apadrinamiento) {
        this.apadrinamiento = apadrinamiento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEnvío != null ? idEnvío.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CartasPaquetes)) {
            return false;
        }
        CartasPaquetes other = (CartasPaquetes) object;
        if ((this.idEnvío == null && other.idEnvío != null) || (this.idEnvío != null && !this.idEnvío.equals(other.idEnvío))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "acoestarea1.entidades.CartasPaquetes[ idEnv\u00edo=" + idEnvío + " ]";
    }
    
}
