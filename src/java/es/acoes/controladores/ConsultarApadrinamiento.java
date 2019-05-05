/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.acoes.controladores;

import es.acoes.entidades.Apadrinamiento;
import es.acoes.entidades.Beca;
import es.acoes.entidades.Beneficiario;
import es.acoes.entidades.CartasPaquetes;
import es.acoes.entidades.Joven;
import es.acoes.entidades.Socio;
import es.acoes.entidades.Usuario;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Usuario
 */
@Named(value = "ConsultarApadrinamiento")
@SessionScoped
public class ConsultarApadrinamiento implements Serializable {
    
    private List<Apadrinamiento> ap = new ArrayList<>();
    private List<Usuario> lu = new ArrayList<>();

    public List<Usuario> getLu() {
        return lu;
    }

    public void setLu(List<Usuario> lu) {
        this.lu = lu;
    }
    private Apadrinamiento apadrinamiento;
    private Integer idEnvio;
    private String contenido;
    private String fechaEnvio;
  


    public Apadrinamiento getApadrinamiento() {
        return apadrinamiento;
    }

    public void setApadrinamiento(Apadrinamiento apadrinamiento) {
        this.apadrinamiento = apadrinamiento;
    }

    public Integer getIdEnvio() {
        return idEnvio;
    }

    public void setIdEnvio(Integer idEnvio) {
        this.idEnvio = idEnvio;
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

    public ConsultarApadrinamiento() {
       
        Usuario  u1 = new Usuario("12345678A","pepe", "asdf", "pepe@gmail.com",Usuario.Rol.SOCIO);
        Usuario u2 = new Usuario("98765312Z","Jaime", "asdfe", "jaime@gmail.com",Usuario.Rol.SOCIO);
        Usuario u3 = new Usuario("98765432Z","manolo", "qwer", "manolo@gmail.com",Usuario.Rol.ADMINISTRADOR);
        Usuario u4 = new Usuario("12345678B","adrian","1234","adrian@lacasa.com",Usuario.Rol.COORDINADOR);
        
        Socio s1 = new Socio(u1, "pepe", "gutierrez", "malaga residencia jimenez frauz", 952677667);
        Socio s2 = new Socio(u2,"jaime", "manuel", "la sagrada familia", 543781239);
        u1.setSocio(s1);
        u2.setSocio(s2);
        
        Joven j1 = new Joven(1,"jimenez los santos",new Date(),2,"sostenible", new Beneficiario(1,"marta","calle amargura","sur",null), new ArrayList<>(), new ArrayList<>());
        Joven j2 = new Joven(2,"moreno",new Date(),4,"muy preocupante", new Beneficiario(2,"antonio","calle cristo","este",null), new ArrayList<>(), new ArrayList<>());
        Joven j3 = new Joven(3,"rubio",new Date(),1,"aceptable", new Beneficiario(3,"antonio","calle larios","oeste",null), new ArrayList<>(), new ArrayList<>());
        Joven j4 = new Joven();
        Apadrinamiento a1 = new Apadrinamiento(j1,s1);
        Apadrinamiento a2 = new Apadrinamiento(j2,s1);
        CartasPaquetes cp1 = new CartasPaquetes(111, "Conjunto de postales", new Date(),a1);
        a1.getCartasPaquetesList().add(cp1);
        Apadrinamiento a3 = new Apadrinamiento(j3,s2);
        Apadrinamiento a4 = new Apadrinamiento(null,s1);
        a1.setFechaFin(new Date());
        a1.setFechaConfirmacion(new Date());
        a2.setFechaConfirmacion(new Date());
        a3.setFechaConfirmacion(new Date());
        
        lu.add(u1);
        lu.add(u2);
        lu.add(u3);
        lu.add(u4);
        ap.add(a1);
        ap.add(a2);
        ap.add(a3);
        ap.add(a4);
    }

    
    public List<Apadrinamiento> getApadrinamientos() {
        return ap;
    }

    public void setApadrinamientos(List<Apadrinamiento> ap) {
        this.ap = ap;
    }
    
    public void finalizar(Apadrinamiento ap){
        ap.setFechaFin(new Date());
        
    }
    
    public String añadirEnvio(Apadrinamiento ap){
        this.apadrinamiento = ap;
        return "añadirEnvio.xhtml";
    }
    
    public String añadir(){
        int index =ap.indexOf(apadrinamiento);
        ap.get(index).getCartasPaquetesList().add(new CartasPaquetes(idEnvio, contenido, new Date(),apadrinamiento));
        return "admin_consultarApadrinamientos.xhtml";
    }
    
    public List<Apadrinamiento> getApadrinamientosByDni(String dni){
        
        List<Apadrinamiento> aux = new ArrayList<>();
        
        for(Apadrinamiento e : this.ap){
            if(e.getSocio().getUsuario().getDni() == dni){
                aux.add(e);
            }
        }
        
        return aux;
    }
    
    public List<CartasPaquetes> getEnviosByDni(String dni){
        List<CartasPaquetes> aux = new ArrayList<>();
        for(Apadrinamiento e : this.ap){
            if(e.getSocio().getUsuario().getDni() == dni){
               
                for(CartasPaquetes i : e.getCartasPaquetesList()){
                    aux.add(i);
                }
            }
        }
        return aux;
    }
    
    public String vincularJoven(Apadrinamiento ap){
        this.apadrinamiento = ap;
        return "vincularJoven.xhtml";
    }
    
    public String seleccionarJoven(Joven joven){
        apadrinamiento.setJoven(joven);
        apadrinamiento.setFechaConfirmacion(new Date());
        return "admin_consultarApadrinamientos.xhtml";
    }
    
    public void eliminarUsuario(Usuario usuario){
        lu.remove(usuario);
    }
    
}
