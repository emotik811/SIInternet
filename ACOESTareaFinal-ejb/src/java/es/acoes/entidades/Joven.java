/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.acoes.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "JOVEN")
public class Joven implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_BENEFICIARIO")
    private Integer idBeneficiario;
    @Basic(optional = false)
    @Column(name = "APELLIDOS")
    private String apellidos;
    @Basic(optional = false)
    @Column(name = "FECHA_NACIMIENTO")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Column(name = "NUMERO_FAMILIARES")
    private Integer numeroFamiliares;
    @Column(name = "SITUACION_ECONOMICA")
    private String situacionEconomica;
    @JoinColumn(name = "JOVEN_ID_BENEFICIARIO", referencedColumnName = "ID_BENEFICIARIO", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Beneficiario beneficiario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "joven")
    private List<Apadrinamiento> apadrinamientoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "jovenIdBeneficiario")
    private List<Beca> becaList;

    public Joven() {
        this.idBeneficiario = 1;
        this.apellidos="aa";
        this.fechaNacimiento=new Date();
        this.beneficiario = new Beneficiario();
    }

    public Joven(Integer idBeneficiario, String apellidos, Date fechaNacimiento, Integer numeroFamiliares, String situacionEconomica, Beneficiario beneficiario, List<Apadrinamiento> apadrinamientoList, List<Beca> becaList) {
        this.idBeneficiario = idBeneficiario;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.numeroFamiliares = numeroFamiliares;
        this.situacionEconomica = situacionEconomica;
        this.beneficiario = beneficiario;
        this.apadrinamientoList = apadrinamientoList;
        this.becaList = becaList;
    }
    
    

    public Integer getIdBeneficiario() {
        return idBeneficiario;
    }

    public void setIdBeneficiario(Integer idBeneficiario) {
        this.idBeneficiario = idBeneficiario;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Integer getNumeroFamiliares() {
        return numeroFamiliares;
    }

    public void setNumeroFamiliares(Integer numeroFamiliares) {
        this.numeroFamiliares = numeroFamiliares;
    }

    public String getSituacionEconomica() {
        return situacionEconomica;
    }

    public void setSituacionEconomica(String situacionEconomica) {
        this.situacionEconomica = situacionEconomica;
    }

    public Beneficiario getBeneficiario() {
        return beneficiario;
    }

    public void setBeneficiario(Beneficiario beneficiario) {
        this.beneficiario = beneficiario;
    }

    public List<Apadrinamiento> getApadrinamientoList() {
        return apadrinamientoList;
    }

    public void setApadrinamientoList(List<Apadrinamiento> apadrinamientoList) {
        this.apadrinamientoList = apadrinamientoList;
    }

    public List<Beca> getBecaList() {
        return becaList;
    }

    public void setBecaList(List<Beca> becaList) {
        this.becaList = becaList;
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
        if (!(object instanceof Joven)) {
            return false;
        }
        Joven other = (Joven) object;
        if ((this.idBeneficiario == null && other.idBeneficiario != null) || (this.idBeneficiario != null && !this.idBeneficiario.equals(other.idBeneficiario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "acoestarea1.entidades.Joven[ idBeneficiario=" + idBeneficiario + " ]";
    }
    
}
