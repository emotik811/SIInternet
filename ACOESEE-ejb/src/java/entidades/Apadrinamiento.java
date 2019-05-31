/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "APADRINAMIENTO")
public class Apadrinamiento implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ApadrinamientoPK apadrinamientoPK;
    @Column(name = "OBSERVACIONES")
    private String observaciones;
    @Basic(optional = false)
    @Column(name = "FECHA_SOLICITUD")
    @Temporal(TemporalType.DATE)
    private Date fechaSolicitud;
    @Column(name = "FECHA_CONFIRMACION")
    @Temporal(TemporalType.DATE)
    private Date fechaConfirmacion;
    @Column(name = "FECHA_FIN")
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "apadrinamiento", fetch = FetchType.LAZY)
    private List<Envio> envioList;
    @JoinColumn(name = "JOVEN_ID_JOVEN", referencedColumnName = "ID_JOVEN", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Joven joven;
    @JoinColumn(name = "SOCIO_USERNAME", referencedColumnName = "USERNAME", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Socio socio;

    public Apadrinamiento() {
        this.envioList = new ArrayList<>();
    }

    public Apadrinamiento(ApadrinamientoPK apadrinamientoPK) {
        this.apadrinamientoPK = apadrinamientoPK;
        this.envioList = new ArrayList<>();
    }

    public Apadrinamiento(ApadrinamientoPK apadrinamientoPK, Timestamp fechaSolicitud) {
        this.apadrinamientoPK = apadrinamientoPK;
        this.fechaSolicitud = fechaSolicitud;
    }

    public Apadrinamiento(Socio socioUsername, Joven jovenIdJoven) {
        joven = jovenIdJoven;
        socio = socioUsername;
        
        this.envioList = new ArrayList<>();
    }

    public ApadrinamientoPK getApadrinamientoPK() {
        return apadrinamientoPK;
    }

    public void setApadrinamientoPK(ApadrinamientoPK apadrinamientoPK) {
        this.apadrinamientoPK = apadrinamientoPK;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Date getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(Date fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public Date getFechaConfirmacion() {
        return fechaConfirmacion;
    }

    public void setFechaConfirmacion(Date fechaConfirmacion) {
        this.fechaConfirmacion = fechaConfirmacion;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    @XmlTransient
    public List<Envio> getEnvioList() {
        return envioList;
    }

    public void setEnvioList(List<Envio> envioList) {
        this.envioList = envioList;
    }

    public Joven getJoven() {
        return joven;
    }

    public void setJoven(Joven joven) {
        this.joven = joven;
    }

    public Socio getSocio() {
        return socio;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (apadrinamientoPK != null ? apadrinamientoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Apadrinamiento)) {
            return false;
        }
        Apadrinamiento other = (Apadrinamiento) object;
        if ((this.apadrinamientoPK == null && other.apadrinamientoPK != null) || (this.apadrinamientoPK != null && !this.apadrinamientoPK.equals(other.apadrinamientoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Apadrinamiento[ apadrinamientoPK=" + apadrinamientoPK + " ]";
    }
    
}
