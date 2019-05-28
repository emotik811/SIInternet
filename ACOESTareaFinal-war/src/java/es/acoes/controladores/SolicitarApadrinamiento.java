/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.acoes.controladores;

import es.acoes.entidades.Apadrinamiento;
import es.acoes.entidades.Beneficiario;
import es.acoes.entidades.Joven;
import java.util.Date;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import negocio.Negocio;

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
            return ctl.salir();
        } else {
            Apadrinamiento a = new Apadrinamiento();
            a.setSocio(ctl.getUsuario().getSocio());
            Beneficiario b = new Beneficiario();
            Joven j = new Joven();
            j.setBeneficiario(b);
            a.setJoven(j);
            a.setFechaSolicitud(new Date());
            negocio.solicitarApadr(a);
            return ctl.home();
        }
    }
}
