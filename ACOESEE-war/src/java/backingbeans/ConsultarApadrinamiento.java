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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
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


    
    public List<Apadrinamiento> getAllApadrinamientos() {
        
        return negocio.getAllApadrinamientos();
    }

    
    public void finalizar(Apadrinamiento ap){
        ap.setFechaFin(new Date());
        
    }
    
    public String añadirEnvio(Apadrinamiento ap){
        this.apadrinamiento = ap;
        return "añadirEnvio.xhtml";
    }
    
    public String añadir(){
        /*int index =ap.indexOf(apadrinamiento);
        ap.get(index).getEnvioList().add(new Envio(new Date(), contenido,apadrinamiento));*/
        return "admin_consultarApadrinamientos.xhtml";
    }
    
    public List<Apadrinamiento> getApadrinamientosByUsername(String username){
        List<Apadrinamiento> apList = negocio.consultarApadrinamiento(username);
        List<Apadrinamiento> aux = new ArrayList<>();
        for(Apadrinamiento apa : apList) {
            if(apa.getApadrinamientoPK().getJovenIdJoven() != -1) {
                aux.add(apa);
            }
        }
        return aux;
    }
    
    public List<Envio> getEnviosByUsername(String username){
        List<Envio> aux = new ArrayList<>();
        /*for(Apadrinamiento e : this.ap){
            if(e.getSocio().getUsername().equals(username)){
               
                for(Envio i : e.getEnvioList()){
                    aux.add(i);
                }
            }
        }*/
        return aux;
    }
    
    public String vincularJoven(Apadrinamiento ap){
        this.apadrinamiento = ap;
        return "vincularJoven.xhtml";
    }
    
    public String seleccionarJoven(Joven joven){
        negocio.asignarApadrinamiento(apadrinamiento,joven);
        return "admin_consultarApadrinamientos.xhtml";
    }
    
    public void eliminarUsuario(Usuario usuario){
        lu.remove(usuario);
    }
    
}
