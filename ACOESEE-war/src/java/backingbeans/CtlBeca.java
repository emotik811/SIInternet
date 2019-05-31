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
import javax.inject.Named;

/**
 *
 * @author Usuario
 */
@Named(value="CtlBeca")
@SessionScoped
public class CtlBeca implements Serializable{
    
    private List<Beca> listaBecas = new ArrayList<>();
    private Integer idJoven;
    private Beca b;
    private Integer idBeca;
    private String tipo;
    private Date fechaPeticion;
    
    public CtlBeca(){
    }

    public List<Beca> getListaBecas() {
        return listaBecas;
    }

    public void setListaBecas(List<Beca> listaBecas) {
        this.listaBecas = listaBecas;
    }
    

    public Integer getIdJoven() {
        return idJoven;
    }

    public void setIdJoven(Integer idJoven) {
        this.idJoven = idJoven;
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
