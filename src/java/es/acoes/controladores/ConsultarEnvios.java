/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.acoes.controladores;

import es.acoes.entidades.Apadrinamiento;
import es.acoes.entidades.CartasPaquetes;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Usuario
 */
@Named(value = "ConsultarEnvios")
@SessionScoped
public class ConsultarEnvios implements Serializable {
    
    private List<CartasPaquetes> envios;

    
    public Integer getIdEnvio() {
        return idEnvio;
    }

    public void setIdEnvio(Integer idEnvio) {
        this.idEnvio = idEnvio;
    }

    public Date getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(Date fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Date getFechaRecepcion() {
        return fechaRecepcion;
    }

    public void setFechaRecepcion(Date fechaRecepcion) {
        this.fechaRecepcion = fechaRecepcion;
    }

    public Apadrinamiento getApadrinamiento() {
        return apadrinamiento;
    }

    public void setApadrinamiento(Apadrinamiento apadrinamiento) {
        this.apadrinamiento = apadrinamiento;
    }
  
    private Integer idEnvio;
    private Date fechaEnvio;
    private String contenido;
    private Date fechaRecepcion;
    
    private Apadrinamiento apadrinamiento;
   
    
    public ConsultarEnvios() {
        
    }

    public List<CartasPaquetes> getEnvios() {
        return envios;
    }

    public void setEnvios(List<CartasPaquetes> envios) {
        this.envios = envios;
    }
    

    
    
    
}
