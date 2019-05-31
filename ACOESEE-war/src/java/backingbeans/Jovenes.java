/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backingbeans;

import entidades.Apadrinamiento;
import entidades.Beca;
import entidades.Joven;
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
 * @author USUARIO
 */

@Named(value = "Jovenes")
@SessionScoped
public class Jovenes implements Serializable {
    
    private List<Joven> listaJovenes = new ArrayList<Joven>();
    
  // Joven atributos 
    private String nombre;
    private String apellidos;
    private String direccion;
    private String localidad;
    
    private String fechaNacimiento;
    private Integer numeroFamiliares;
    private String situacionEconomica;
    
    @Inject
    private Negocio negocio;
    

    public Jovenes() {
    }

    public List<Joven> getListaJovenes() {
        return listaJovenes;
    }

    public void setListaJovenes(List<Joven> listaJovenes) {
        this.listaJovenes = listaJovenes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Integer getNumeroFamiliares() {
        return numeroFamiliares;
    }

    public void setNumeroFamiliares(Integer numeroFamiliares) {
        this.numeroFamiliares = numeroFamiliares;
    }

    public String getSituacionEconomica() {
        return situacionEconomica;
    }

    public void setSituacionEconomica(String situacionEconomica) {
        this.situacionEconomica = situacionEconomica;
    }
    
    public String añadirJoven(){
        return "añadirJoven.xhtml";
    }
    
    public String finalizarAñadirJoven(){
        try {
            Joven j = new Joven();
            j.setNombre(nombre);
            j.setApellidos(apellidos);
            j.setDireccion(direccion);
            j.setNumeroFamiliares(numeroFamiliares);
            j.setSituacionEconomica(situacionEconomica);
            Date date = new SimpleDateFormat("dd/MM/yyyy").parse(fechaNacimiento);
            j.setFechaNacimiento(date);
            negocio.añadirJoven(j);
        } catch (ParseException ex) {
            Logger.getLogger(Jovenes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "jovenes.xhtml";
    }
    
    

    public List<Joven> getJovenes() {
        return negocio.getAllJovenes();
    }
    
    public Joven getJoven(){
        return listaJovenes.get(0);
    }

    public void setJovenes(List<Joven> jovenes) {
        this.listaJovenes = jovenes;
    }
    
    public void eliminarJoven(Joven j){
        negocio.eliminarJoven(j);
    }
    

    
    
}

