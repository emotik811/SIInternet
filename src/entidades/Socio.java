/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Usuario
 */
@Entity
public class Socio extends Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @OneToMany (mappedBy="socio")
    private List<Apadrinamientos> apadrinamientos;
    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private String apellidos;
    private String direccion;
    private String telefono;

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

    public Socio() {
    }

    
}
