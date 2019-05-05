/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.acoes.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "BENEFICIARIO")
public class Beneficiario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_BENEFICIARIO")
    private Integer idBeneficiario;
    @Basic(optional = false)
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "DIRECCION")
    private String direccion;
    @Column(name = "LOCALIDAD")
    private String localidad;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "beneficiario")
    private Joven joven;

    public Beneficiario() {
        
    }

    public Beneficiario(Integer idBeneficiario, String nombre, String direccion, String localidad, Joven joven) {
        this.idBeneficiario = idBeneficiario;
        this.nombre = nombre;
        this.direccion = direccion;
        this.localidad = localidad;
        this.joven = joven;
    }
    
    

    public Integer getIdBeneficiario() {
        return idBeneficiario;
    }

    public void setIdBeneficiario(Integer idBeneficiario) {
        this.idBeneficiario = idBeneficiario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public Joven getJoven() {
        return joven;
    }

    public void setJoven(Joven joven) {
        this.joven = joven;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBeneficiario != null ? idBeneficiario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Beneficiario)) {
            return false;
        }
        Beneficiario other = (Beneficiario) object;
        if ((this.idBeneficiario == null && other.idBeneficiario != null) || (this.idBeneficiario != null && !this.idBeneficiario.equals(other.idBeneficiario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "acoestarea1.entidades.Beneficiario[ idBeneficiario=" + idBeneficiario + " ]";
    }
    
}
