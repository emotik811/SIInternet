/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backingbeans;

import entidades.Apadrinamiento;
import entidades.ApadrinamientoPK;
import entidades.Beca;
import entidades.Envio;
import entidades.Joven;
import entidades.Socio;
import entidades.Usuario;
import java.io.Serializable;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import negocio.ACOESException;
import negocio.Negocio;

/**
 *
 * @author Usuario
 */
@Named(value = "ConsultarApadrinamiento")
@SessionScoped
public class ConsultarApadrinamiento implements Serializable {
    
    private List<Usuario> lu = new ArrayList<>();

    @Inject
    private Negocio negocio;
    
    public ConsultarApadrinamiento() {
       
    }
    
    public List<Usuario> getLu() {
        return lu;
    }

    public void setLu(List<Usuario> lu) {
        this.lu = lu;
    }
    
    private Apadrinamiento apadrinamiento;
    private String contenido;
    private String fechaEnvio;
    private String fechaRecepcion;

    public Apadrinamiento getApadrinamiento() {
        return apadrinamiento;
    }

    public void setApadrinamiento(Apadrinamiento apadrinamiento) {
        this.apadrinamiento = apadrinamiento;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(String fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }
    
    public String getFechaRecepcion() {
        return fechaRecepcion;
    }

    public void setFechaRecepcion(String fechaRecepcion) {
        this.fechaRecepcion = fechaRecepcion;
    }

    public Boolean isApadrinado(Joven j) {
        return negocio.isApadrinado(j);
    }

    public List<Apadrinamiento> getAllApadrinamientos() {
        return negocio.getAllApadrinamientos();
    }

    
    public void finalizar(Apadrinamiento ap){
        negocio.setFechaFin(ap);
    }
    
    public String añadirEnvio(Apadrinamiento ap){
        this.apadrinamiento = ap;
        return "añadirEnvio.xhtml";
    }
    
    public String añadir(){
        negocio.añadirEnvio(this.apadrinamiento,this.contenido,this.fechaEnvio,this.fechaRecepcion);
        return "admin_consultarApadrinamientos.xhtml";
    }
    
    public List<Apadrinamiento> getApadrinamientosByUsername(String username){
        return negocio.consultarApadrinamiento(username);
    }
    
    public List<Envio> getEnviosByUsername(String username){
        return negocio.getEnviosUsername(username);
    }
    
    public String vincularJoven(Apadrinamiento ap){
        this.apadrinamiento = ap;
        return "vincularJoven.xhtml";
    }
    
    public String seleccionarJoven(Joven joven){
        try {
            negocio.asignarApadrinamiento(apadrinamiento,joven);
        } catch (ACOESException ex) {
            FacesMessage fm = new FacesMessage("El socio ya ha sido padrino de este niño");
            FacesContext.getCurrentInstance().addMessage("login:user", fm);}
        return "admin_consultarApadrinamientos.xhtml";
    }
    
    public void eliminarUsuario(Usuario usuario){
        lu.remove(usuario);
    }
    
}
