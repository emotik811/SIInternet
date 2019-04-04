/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

/**
 *
 * @author Usuario
 */
@Entity
public class Apadrinamientos implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @ManyToOne
    private Socio socio;
    
    @Id
    @ManyToOne
    private Joven joven;
    
    @OneToMany (mappedBy = "entrega",cascade = CascadeType.PERSIST)
    private List<Cartas_paquetes> entregas;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(nullable = false)
    private Date fecha_solicitud;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha_confirmacion;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha_fin;
    
    @Column(length= 300)
    private String obervaciones;
    
    
    public Apadrinamientos() {
        
    }

    public Socio getSocio() {
        return socio;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }

    public Joven getJoven() {
        return joven;
    }

    public void setJoven(Joven joven) {
        this.joven = joven;
    }

    public List<Cartas_paquetes> getEntregas() {
        return entregas;
    }

    public void setEntregas(List<Cartas_paquetes> entregas) {
        this.entregas = entregas;
    }

    public Date getFecha_solicitud() {
        return fecha_solicitud;
    }

    public void setFecha_solicitud(Date fecha_solicitud) {
        this.fecha_solicitud = fecha_solicitud;
    }

    public Date getFecha_confirmacion() {
        return fecha_confirmacion;
    }

    public void setFecha_confirmacion(Date fecha_confirmacion) {
        this.fecha_confirmacion = fecha_confirmacion;
    }

    public Date getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(Date fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public String getObervaciones() {
        return obervaciones;
    }

    public void setObervaciones(String obervaciones) {
        this.obervaciones = obervaciones;
    }

   

    
    
}
