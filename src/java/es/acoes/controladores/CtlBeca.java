/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.acoes.controladores;

import es.acoes.entidades.Beca;
import es.acoes.entidades.Beca.Estado;
import es.acoes.entidades.Beneficiario;
import es.acoes.entidades.Joven;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Usuario
 */
@Named(value="CtlBeca")
@SessionScoped
public class CtlBeca implements Serializable{
    
    private List<Beca> listaBecas = new ArrayList<>();
    
    private Integer idBeneficiario;
    private Integer idBeca;
    private String tipo;
    private Date fechaPeticion;
    
    public CtlBeca(){
        Joven j2 = new Joven(2,"marlon",new Date(),3,"precaria", new Beneficiario(2,"miguel","calle falsa","norte",null), new ArrayList<>(), new ArrayList<>());
        Joven j1 = new Joven(1,"jimenez los santos",new Date(),2,"sostenible", new Beneficiario(1,"marta","calle amargura","sur",null), new ArrayList<>(), new ArrayList<>());
        Beca b1 = new Beca(01,"San Miguel",Estado.EN_ESPERA, new Date(),j1);
        Beca b2 = new Beca(02,"San Miguel",Estado.EN_ESPERA, new Date(),j2);
        
        listaBecas.add(b1);
        listaBecas.add(b2);
    }

    public List<Beca> getListaBecas() {
        return listaBecas;
    }

    public void setListaBecas(List<Beca> listaBecas) {
        this.listaBecas = listaBecas;
    }
    

    public Integer getIdBeneficiario() {
        return idBeneficiario;
    }

    public void setIdBeneficiario(Integer idBeneficiario) {
        this.idBeneficiario = idBeneficiario;
    }

    public Integer getIdBeca() {
        return idBeca;
    }

    public void setIdBeca(Integer idBeca) {
        this.idBeca = idBeca;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Date getFechaPeticion() {
        return fechaPeticion;
    }

    public void setFechaPeticion(Date fechaPeticion) {
        this.fechaPeticion = fechaPeticion;
    }
    
    public String solicitarBeca(){
        return "becas.xhtml";
    }
    
    public void aceptarSolicitud(Beca beca){
        beca.setFechaResolucion(new Date());
        beca.setEstado(Estado.ACEPTADA);
    }
    
    public void rechazarSolicitud(Beca beca){
        beca.setFechaResolucion(new Date());
        beca.setEstado(Estado.RECHAZADA);
    }
    
    public boolean checkEnEspera(Beca beca){
        
        return beca.getEstado().equals(Estado.EN_ESPERA);
    }
}
