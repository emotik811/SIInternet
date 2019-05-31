/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlTransient;

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
    @GeneratedValue(strategy = GenerationType.TABLE,generator = "joven_id_table")
    @TableGenerator(name="joven_id_table",table="joven_id_table",allocationSize=1,initialValue=1)
    @Column(name = "ID_JOVEN")
    private Integer idJoven;
    @Basic(optional = false)
    @Column(name = "NOMBRE")
    private String nombre;
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
    @Column(name = "DIRECCION")
    private String direccion;
    @Column(name = "LOCALIDAD")
    private String localidad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "joven", fetch = FetchType.LAZY)
    private List<Apadrinamiento> apadrinamientoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "jovenIdJoven", fetch = FetchType.LAZY)
    private List<Beca> becaList;

    public Joven() {
        apadrinamientoList = new ArrayList<>();
        becaList = new ArrayList<>();
    }

    public Integer getIdJoven() {
        return idJoven;
    }

    public void setIdJoven(Integer idJoven) {
        this.idJoven = idJoven;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    @XmlTransient
    public List<Apadrinamiento> getApadrinamientoList() {
        return apadrinamientoList;
    }

    public void setApadrinamientoList(List<Apadrinamiento> apadrinamientoList) {
        this.apadrinamientoList = apadrinamientoList;
    }

    @XmlTransient
    public List<Beca> getBecaList() {
        return becaList;
    }

    public void setBecaList(List<Beca> becaList) {
        this.becaList = becaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idJoven != null ? idJoven.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Joven)) {
            return false;
        }
        Joven other = (Joven) object;
        if ((this.idJoven == null && other.idJoven != null) || (this.idJoven != null && !this.idJoven.equals(other.idJoven))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Joven[ idJoven=" + idJoven + " ]";
    }
    
}
