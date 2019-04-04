/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

/**
 *
 * @author Usuario
 */
@Entity
@DiscriminatorValue("S")
public class Socio extends Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @OneToMany (mappedBy="socio",cascade = CascadeType.PERSIST)
    private List<Apadrinamientos> apadrinamientos;
    

    private String nombre;
    

    private String apellidos;
    
    private String direccion;
    
    private String telefono;
    
    public Socio() {
        
    }

    public List<Apadrinamientos> getApadrinamientos() {
        return apadrinamientos;
    }

    public void setApadrinamientos(List<Apadrinamientos> apadrinamientos) {
        this.apadrinamientos = apadrinamientos;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
