/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backingbeans;

import entidades.Usuario;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import negocio.ACOESException;
import negocio.CuentaRepetidaException;
import negocio.IdentificacionFallidaException;
import negocio.Negocio;
import negocio.UsuarioNoEncontradoException;

/**
 *
 * @author Usuario
 */
@Named(value = "login")
@SessionScoped
public class Login implements Serializable {

    private String usuario;
    private String contraseña;
    
    @Inject
    private Negocio negocio;
    
    @Inject
    private CtlAutorizacion ctl;
    
    public Login() {
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
        try {
            Usuario u = new Usuario();
            u.setUsername(usuario);
            u.setPassword(contraseña);
            negocio.comprobarLogin(u);
            ctl.setUsuario(negocio.refrescarUsuario(u));
            return ctl.home();
        } catch (IdentificacionFallidaException ex) {
            FacesMessage fm = new FacesMessage("Contraseña Incorrecta");
            FacesContext.getCurrentInstance().addMessage("login:user", fm);
        } catch (UsuarioNoEncontradoException ex) {
            FacesMessage fm = new FacesMessage("La cuenta no existe");
            FacesContext.getCurrentInstance().addMessage("login:user", fm);
        } catch (CuentaRepetidaException ex) {
            FacesMessage fm = new FacesMessage("La cuenta esta repetida");
            FacesContext.getCurrentInstance().addMessage("login:user", fm);
        } catch (ACOESException ex) {
            FacesMessage fm = new FacesMessage("Error no disponible");
            FacesContext.getCurrentInstance().addMessage("login:user", fm);
        }
        return null;
        
    }
    
    public String registrar() {
        return "registro.xhtml";
    }
}
