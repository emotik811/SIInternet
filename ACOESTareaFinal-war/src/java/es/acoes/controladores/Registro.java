/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.acoes.controladores;

import es.acoes.entidades.Socio;
import es.acoes.entidades.Usuario;
import es.acoes.entidades.Usuario.Rol;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import negocio.Negocio;

/**
 *
 * @author Usuario
 */
@Named(value="registro")
@RequestScoped
public class Registro {
    private String email;
    private String direccion;
    private String telefono;
    private String nombre;
    private String apellidos;
    private String dni;
    private String usuario;
    private String contraseña;
    private Rol rol;
    @Inject
    private Negocio negocio;
    
    
    public Registro() {
        
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    
    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
    
    
    
    public String registrar() {
        Usuario u = new Usuario();
        
        u.setMail(email);
        u.setUsername(usuario);
        u.setPassword(contraseña);
        u.setRol(Usuario.Rol.SOCIO);
        negocio.registrar(u);
        if(u.getRol() == Usuario.Rol.SOCIO) {
            
            Socio s = new Socio();
            s.setUsuario(u);
            s.setDni(dni);
            s.setNombre(nombre);
            s.setApellidos(apellidos);
            s.setTelefono(Integer.parseInt(telefono));
            s.setDireccion(direccion);
            negocio.agnadirSocio(s);
        }
        return "login.xhtml";
    }
    
}
