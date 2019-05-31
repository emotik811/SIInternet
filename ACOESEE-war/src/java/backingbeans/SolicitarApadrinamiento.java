/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backingbeans;

import entidades.Apadrinamiento;
import entidades.ApadrinamientoPK;
import entidades.Usuario;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import negocio.ACOESException;
import negocio.CuentaRepetidaException;
import negocio.IdentificacionFallidaException;
import negocio.Negocio;
import negocio.SolicitarApadrinamientoException;
import negocio.UsuarioNoEncontradoException;

/**
 *
 * @author Usuario
 */
@Named(value = "solicitarApadrinamiento")
@RequestScoped
public class SolicitarApadrinamiento {

    private Boolean derechos;
    @Inject
    private CtlAutorizacion ctl;
    @Inject
    private Negocio negocio;
    
    /**
     * Creates a new instance of SolicitarApadrinamiento
     */
    public SolicitarApadrinamiento() {
    }

    public Boolean getDerechos() {
        return derechos;
    }

    public void setDerechos(Boolean derechos) {
        this.derechos = derechos;
    }
    
    public String solicitar() {
        if(derechos == false) {
            try {
                throw new ACOESException();
            } catch (ACOESException ex) {
                FacesMessage fm = new FacesMessage("Los derechos no han sido aceptados y no se puede continuar.");
                FacesContext.getCurrentInstance().addMessage("login:user", fm);
            }
        } else {
            try {
                Apadrinamiento ap = new Apadrinamiento();
                ap.setSocio(ctl.getUsuario().getSocio());
                ap.setJoven(null);
                ap.setFechaSolicitud(new Date());
                Usuario u = negocio.solicitarApadrinamiento(ap);
                ctl.setUsuario(u);
            } catch (IdentificacionFallidaException ex) {
                FacesMessage fm = new FacesMessage("Contraseña Incorrecta.");
                FacesContext.getCurrentInstance().addMessage("login:user", fm);
            } catch (UsuarioNoEncontradoException ex) {
                FacesMessage fm = new FacesMessage("La cuenta no existe.");
                FacesContext.getCurrentInstance().addMessage("login:user", fm);
            } catch (CuentaRepetidaException ex) {
                FacesMessage fm = new FacesMessage("La cuenta esta repetida.");
                FacesContext.getCurrentInstance().addMessage("login:user", fm);
            } catch (SolicitarApadrinamientoException ex) {
                FacesMessage fm = new FacesMessage("No se pueden solicitar más apadrinamientos hasta que se resuelva la última.");
                FacesContext.getCurrentInstance().addMessage("login:user", fm);
            } catch (ACOESException ex) {
                FacesMessage fm = new FacesMessage("Error no disponible.");
                FacesContext.getCurrentInstance().addMessage("login:user", fm);
            }
        }
        return "solicitar_apad.xhtml";
    }
    
}
