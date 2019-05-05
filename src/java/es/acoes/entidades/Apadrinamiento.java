/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.acoes.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "apadrinamiento")
    private List<CartasPaquetes> cartasPaquetesList;
    @JoinColumn(name = "JOVEN_ID_BENEFICIARIO", referencedColumnName = "ID_BENEFICIARIO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Joven joven;
    @JoinColumn(name = "SOCIO_DNI", referencedColumnName = "DNI", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Socio socio;

    public Apadrinamiento(Joven joven, Socio socio) {
        this.joven = joven;
        this.socio = socio;
        fechaSolicitud = new Date();
        this.cartasPaquetesList = new ArrayList<>();
    }
    
    public Apadrinamiento(ApadrinamientoPK apadrinamientoPK) {
        this.apadrinamientoPK = apadrinamientoPK;
    }

    public Apadrinamiento(ApadrinamientoPK apadrinamientoPK, Date fechaSolicitud) {
        this.apadrinamientoPK = apadrinamientoPK;
        this.fechaSolicitud = fechaSolicitud;
    }

    public Apadrinamiento(String socioDni, int jovenIdBeneficiario) {
        this.apadrinamientoPK = new ApadrinamientoPK(socioDni, jovenIdBeneficiario);
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

    public List<CartasPaquetes> getCartasPaquetesList() {
        return cartasPaquetesList;
    }

    public void setCartasPaquetesList(List<CartasPaquetes> cartasPaquetesList) {
        this.cartasPaquetesList = cartasPaquetesList;
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
        return "acoestarea1.entidades.Apadrinamiento[ apadrinamientoPK=" + apadrinamientoPK + " ]";
    }
    
}
