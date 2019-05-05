/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.acoes.controladores;

import es.acoes.entidades.Usuario.Rol;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Usuario
 */
@Named(value="registro")
@RequestScoped
public class Registro {
    
    private String usuario;
    private String contraseña;
    private Rol rol;
    

    
    
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
    
    public String registrar() {
        return "login.xhtml";
    }
    
}
