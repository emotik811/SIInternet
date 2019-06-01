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
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "BECA")
public class Beca implements Serializable {

    public enum Estado {
        ACEPTADA,
        EN_ESPERA,
        RECHAZADA
    }
    
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.TABLE,generator = "beca_id_table")
    @TableGenerator(name="beca_id_table",table="beca_id_table",allocationSize=1,initialValue=1)
    @Column(name = "ID_BECA")
    private Integer idBeca;
    @Basic(optional = false)
    @Column(name = "TIPO")
    private String tipo;
    @Basic(optional = false)
    @Column(name = "FECHA_PETICION")
    @Temporal(TemporalType.DATE)
    private Date fechaPeticion;
    @Column(name = "FECHA_RESOLUCION")
    @Temporal(TemporalType.DATE)
    private Date fechaResolucion;
    @Column(name = "CUANTIA")
    private Integer cuantia;
    @JoinColumn(name = "JOVEN_ID_JOVEN", referencedColumnName = "ID_JOVEN")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Joven jovenIdJoven;
    @Basic(optional = false)
    @Column(name = "ESTADO")
    @Enumerated(EnumType.STRING)
    private Estado estado;

    public Beca() {
    }

    public Beca(String tipo, Estado estado, Date fechaPeticion,Joven j) {
        this.tipo = tipo;
        this.estado = estado;
        this.fechaPeticion = fechaPeticion;
        this.jovenIdJoven = j;
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
    
    // Método para ver una fecha de forma simplificada. (dd/mm/yyyy)
    public String getFechaPeticionSimple() {
        int dia = fechaPeticion.getDate();
        int mes = fechaPeticion.getMonth()+1;
        int anyo = fechaPeticion.getYear()+1900;
        return dia + "/" + mes + "/" + anyo; 
    }

    public Date getFechaResolucion() {
        return fechaResolucion;
    }

    public void setFechaResolucion(Date fechaResolucion) {
        this.fechaResolucion = fechaResolucion;
    }
    
    // Método para ver una fecha de forma simplificada. (dd/mm/yyyy)
    public String getFechaResolucionSimple() {
        if(fechaResolucion == null){
            return null;
        } else {
            int dia = fechaResolucion.getDate();
            int mes = fechaResolucion.getMonth()+1;
            int anyo = fechaResolucion.getYear()+1900;
            return dia + "/" + mes + "/" + anyo; 
        }
    }

    public Integer getCuantia() {
        return cuantia;
    }

    public void setCuantia(Integer cuantia) {
        this.cuantia = cuantia;
    }

    public Joven getJovenIdJoven() {
        return jovenIdJoven;
    }

    public void setjovenIdJoven(Joven jovenIdJoven) {
        this.jovenIdJoven = jovenIdJoven;
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
        return "entidades.Beca[ idBeca=" + idBeca + " ]";
    }
    
}
