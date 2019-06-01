/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "ENVIO")
public class Envio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.TABLE,generator = "envio_id_table")
    @TableGenerator(name="envio_id_table",table="envio_id_table",allocationSize=1,initialValue=1)
    @Column(name = "ID_ENVIOS")
    private Integer idEnvios;
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
        @JoinColumn(name = "APADRINAMIENTO_SOCIO_USERNAME", referencedColumnName = "SOCIO_USERNAME")
        , @JoinColumn(name = "APADRINAMIENTO_JOVEN_ID_JOVEN", referencedColumnName = "JOVEN_ID_JOVEN")})
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Apadrinamiento apadrinamiento;

    public Envio() {
    }

    public Envio(Date fechaEnvio, String contenido, Apadrinamiento ap) {
        this.fechaEnvio = fechaEnvio;
        this.contenido = contenido;
        this.apadrinamiento = ap;
    }

    public Integer getIdEnvios() {
        return idEnvios;
    }

    public Date getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(Date fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }
    
    // Método para ver una fecha de forma simplificada. (dd/mm/yyyy)
    public String getFechaEnvioSimple() {
        if(fechaEnvio == null){
            return null;
        } else {
            int dia = fechaEnvio.getDate();
            int mes = fechaEnvio.getMonth()+1;
            int anyo = fechaEnvio.getYear()+1900;
            return dia + "/" + mes + "/" + anyo; 
        }
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
    
    // Método para ver una fecha de forma simplificada. (dd/mm/yyyy)
    public String getFechaRecepcionSimple() {
        if(fechaRecepcion == null){
            return null;
        } else {
            int dia = fechaRecepcion.getDate();
            int mes = fechaRecepcion.getMonth()+1;
            int anyo = fechaRecepcion.getYear()+1900;
            return dia + "/" + mes + "/" + anyo; 
        }
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
        hash += (idEnvios != null ? idEnvios.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Envio)) {
            return false;
        }
        Envio other = (Envio) object;
        if ((this.idEnvios == null && other.idEnvios != null) || (this.idEnvios != null && !this.idEnvios.equals(other.idEnvios))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Envio[ idEnvios=" + idEnvios + " ]";
    }
    
}
