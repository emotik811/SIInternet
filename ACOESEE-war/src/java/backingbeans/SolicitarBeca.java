/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backingbeans;

import entidades.Envio;
import entidades.Joven;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Usuario
 */
@Named(value = "solicitarBeca")
@SessionScoped
public class SolicitarBeca implements Serializable {
    
    private List<Joven> jovenes;
    
    public SolicitarBeca() {
        
    }

    public List<Joven> getJovenes() {
        return jovenes;
    }

    public void setJovenes(List<Joven> jovenes) {
        this.jovenes = jovenes;
    }
           
}
