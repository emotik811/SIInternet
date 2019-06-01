/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backingbeans;

import entidades.Beca;
import entidades.Beca.Estado;
import entidades.Joven;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import negocio.Negocio;

/**
 *
 * @author Usuario
 */
@Named(value="CtlBeca")
@SessionScoped
public class CtlBeca implements Serializable{
    
    private List<Beca> listaBecas = new ArrayList<>();
    private Joven j;
    private Beca b;
    private Integer idBeca;
    private String tipo;
    private Date fechaPeticion;
    private List<Joven> jovenesList;
    
    @Inject
    private Negocio negocio;
    
    public CtlBeca(){
    }

    public List<Joven> getJovenesList() {
        return negocio.getAllJovenes();
    }

    public void setJovenesList(List<Joven> jovenesList) {
        this.jovenesList = jovenesList;
    }

    public List<Beca> getListaBecas() {
        return listaBecas;
    }

    public void setListaBecas(List<Beca> listaBecas) {
        this.listaBecas = listaBecas;
    }
    

    public Joven getJoven() {
        return j;
    }

    public void setJoven(Joven idJoven) {
        this.j = idJoven;
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

    public Beca getB() {
        return b;
    }

    public void setB(Beca b) {
        this.b = b;
    }
    

    public void setFechaPeticion(Date fechaPeticion) {
        this.fechaPeticion = fechaPeticion;
    }
    
    public String solicitarBeca(){
        negocio.solicitarBeca(this.j,this.tipo);
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
    
    public String seleccionarJoven(){
        
        return "sel_joven.xhtml";
    }
    
    public String selJoven(Joven j) {
        this.j = j;
        return "solicitar_beca.xhtml";
    }
}
