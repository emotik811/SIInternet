/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.acoes.controladores;

import es.acoes.entidades.Usuario;
import es.acoes.entidades.Usuario.Rol;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import negocio.Negocio;

/**
 *
 * @author Usuario
 */
@Named(value = "login")
@SessionScoped
public class Login implements Serializable {

    private String usuario;
    private String contraseña;
    private List<Usuario> usuarios;
    
    @Inject
    private Negocio negocio;
    
    @Inject
    private CtlAutorizacion ctl;
    
    public Login() {
        }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
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
    
    public String autenticar() {
        
        Usuario u = new Usuario();
        u.setUsername(usuario);
        u.setPassword(contraseña);
        Usuario us = negocio.iniciarSesion(u);
        ctl.setUsuario(us);
        return ctl.home();
    }
    
    public String registrar() {
        return "registro.xhtml";
    }
}
