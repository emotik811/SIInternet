/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.acoes.controladores;

import es.acoes.entidades.Apadrinamiento;
import es.acoes.entidades.Beca;
import es.acoes.entidades.Beneficiario;
import es.acoes.entidades.Joven;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

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
    private Integer id;
    private String direccion;
    private String localidad;
    
    private String fechaNacimiento;
    private Integer numeroFamiliares;
    private String situacionEconomica;
    
    

    public Jovenes() {
        List<Beca> listaBecas = new ArrayList<Beca>();
        List<Apadrinamiento> listaApadrinamiento = new ArrayList<Apadrinamiento>();
        Beneficiario b1 = new Beneficiario(1,"jose","calle algarroba","sur",null);
        Joven j1  = new Joven(1,"garcia",new Date(),3,"precaria", b1, listaApadrinamiento, listaBecas);
        
        
        
        listaJovenes.add(j1);
        
        listaJovenes.add(new Joven(2,"jimenez",new Date(),3,"precaria", new Beneficiario(2,"miguel","calle falsa","norte",null), new ArrayList<>(), new ArrayList<>()));
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
        return "jovenes.xhtml";
    }
    
    

    public List<Joven> getJovenes() {
        return listaJovenes;
    }
    
    public Joven getJoven(){
        return listaJovenes.get(0);
    }

    public void setJovenes(List<Joven> jovenes) {
        this.listaJovenes = jovenes;
    }
    
    public void eliminarJoven(Joven joven){
        listaJovenes.remove(joven);
    }
    

    
    
}

