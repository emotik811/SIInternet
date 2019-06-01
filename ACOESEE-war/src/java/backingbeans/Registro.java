/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backingbeans;

import entidades.Socio;
import entidades.Usuario;
import entidades.Usuario.Rol;
import static entidades.Usuario.Rol.ADMINISTRADOR;
import static entidades.Usuario.Rol.COORDINADOR;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import negocio.ACOESException;
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
    private String rol;
    
    @Inject
    private Negocio negocio;
    
    @Inject
    private CtlAutorizacion ctl;
    
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
    
    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
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
        u.setUsername(usuario);
        u.setPassword(contraseña);
        u.setMail(email);
        if(ctl.getUsuario() == null) {
            u.setRol(Usuario.Rol.SOCIO);
            Socio s = new Socio();
            s.setUsername(usuario);
            s.setNombre(nombre);
            s.setApellidos(apellidos);
            s.setTelefono(telefono);
            s.setDni(dni);
            s.setDireccion(direccion);
            s.setUsuario(u);
            u.setSocio(s);
            try {
                negocio.registrarUsuario(u);
            } catch (ACOESException ex) {
                Logger.getLogger(Registro.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            if(this.rol.equals("ADMINISTRADOR")) {
                u.setRol(Usuario.Rol.ADMINISTRADOR);
            } else if(this.rol.equals("COORDINADOR")) {
                u.setRol(Usuario.Rol.COORDINADOR);
            } else {
                u.setRol(Usuario.Rol.SOCIO);
                Socio s = new Socio();
                s.setUsername(usuario);
                s.setNombre(nombre);
                s.setApellidos(apellidos);
                s.setTelefono(telefono);
                s.setDni(dni);
                s.setDireccion(direccion);
                s.setUsuario(u);
                u.setSocio(s);
            }
            try {
                negocio.registrarUsuario(u);
            } catch (ACOESException ex) {
                Logger.getLogger(Registro.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return "login.xhtml";
    }
    
}
