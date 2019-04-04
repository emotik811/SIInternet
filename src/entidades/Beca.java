/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

/**
 *
 * @author Usuario
 */
@Entity
public class Beca implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @ManyToOne
    private Joven joven;

    @Column(nullable = false)
    private String estado;
    @Column(nullable = false)
    private String tipo;
    private Float cuantia;
    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(nullable = false)
    private Date fecha_peticion;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha_resolucion;

    
    
    
    public Beca() {
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Joven getJoven() {
        return joven;
    }

    public void setJoven(Joven joven) {
        this.joven = joven;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Float getCuantia() {
        return cuantia;
    }

    public void setCuantia(Float cuantia) {
        this.cuantia = cuantia;
    }

    public Date getFecha_peticion() {
        return fecha_peticion;
    }

    public void setFecha_peticion(Date fecha_peticion) {
        this.fecha_peticion = fecha_peticion;
    }

    public Date getFecha_resolucion() {
        return fecha_resolucion;
    }

    public void setFecha_resolucion(Date fecha_resolucion) {
        this.fecha_resolucion = fecha_resolucion;
    }
    

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Beca other = (Beca) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Beca{" + "id=" + id + ", joven=" + joven + ", estado=" + estado + ", tipo=" + tipo + ", cuantia=" + cuantia + ", fecha_peticion=" + fecha_peticion + ", fecha_resolucion=" + fecha_resolucion + '}';
    }
    
    
    
}
