/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backingbeans;

import static entidades.Usuario.Rol.ADMINISTRADOR;
import static entidades.Usuario.Rol.COORDINADOR;
import static entidades.Usuario.Rol.SOCIO;
import entidades.Usuario;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import negocio.Negocio;

/**
 *
 * @author Usuario
 */
@Named(value="ctlAutorizacion")
@SessionScoped
public class CtlAutorizacion implements Serializable{
    
    @Inject
    private Negocio negocio;
    private Usuario usuario;
    
    public CtlAutorizacion() {
        
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public List<Usuario> getUsuarios() {
        return negocio.getAllUsers();
    }

    public String eliminarUsuario(Usuario u) {
        negocio.eliminarUsuario(u);
        return "usuarios.xhtml";
    }
    
    
    public String home() {
        if(null == usuario) return "login.xhtml";
        else {
            switch (usuario.getRol()) {
                case SOCIO:
                    return "home_socio.xhtml";
                case ADMINISTRADOR:
                    return "home_admin.xhtml";
                case COORDINADOR:
                    return "home_coordinador.xhtml";
                default:
                    return "login.xhtml";
            }
        }
    }
    
    public String registrar() {
        return "registro.xhtml";
    }
    
    public String aceptarApadrinamiento() {
        return "admin_consultarApadrinamientos.xhtml";
    }
    
    public String añadirCartaPaquete() {
        return null;
    }
    
    public String solicitarBeca() {
        return "solicitar_beca.xhtml";
    }
    
    public String asignarBeca() {
        return null;
    }
    
    public String solicitarApadrinamiento() {
        return "solicitar_apad.xhtml";
    }
    
    public String consultarApadrinamiento() {
        return "consultar_apadrinamiento.xhtml";
        
    }
    
    public String comprobarEstadoBeca(){
        return "becas.xhtml";
    }
    
    public String consultarPaquetes() {
        return "consultar_envios.xhtml";
    }
    
    public String perfil() {
        return "perfil.xhtml";
    }
    
    public String usuarios(){
        return "usuarios.xhtml";
    }
    
    public String jovenes(){
        return "jovenes.xhtml";
    }
    
    public String salir() {
        FacesContext ctx = FacesContext.getCurrentInstance();
        ctx.getExternalContext().invalidateSession();
        usuario = null;
        return "login.xhtml";
    }
    
    

}
