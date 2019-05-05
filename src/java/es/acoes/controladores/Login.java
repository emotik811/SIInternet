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
    private CtlAutorizacion ctl;
    
    public Login() {
        usuarios = new ArrayList<Usuario>();
        usuarios.add(new Usuario("12345678A","pepe", "asdf", "pepe@gmail.com",Rol.SOCIO));
        usuarios.add(new Usuario("98765432Z","manolo", "qwer", "manolo@gmail.com",Rol.ADMINISTRADOR));
        usuarios.add(new Usuario("12345678B","adrian","1234","adrian@lacasa.com",Rol.COORDINADOR));
        usuarios.add(new Usuario("98765312Z","Jaime", "asdfe", "jaime@gmail.com",Usuario.Rol.SOCIO));
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
        for(Usuario u : usuarios) {
            if(usuario.equals(u.getUsername()) && contraseña.equals(u.getPassword())){
                ctl.setUsuario(u);
                return ctl.home();
            }
        }
        FacesContext ctx = FacesContext.getCurrentInstance();
        ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuario o contraseña incorrectos", "Usuario o contraseña incorrectos"));
        return null;
    }
    
    public String registrar() {
        return "registro.xhtml";
    }
}
