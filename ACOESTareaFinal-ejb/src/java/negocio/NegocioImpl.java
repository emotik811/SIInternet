/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import es.acoes.entidades.Apadrinamiento;
import es.acoes.entidades.Socio;
import es.acoes.entidades.Usuario;
import javax.ejb.Stateless;
import javax.ejb.Local;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Usuario
 */
@Stateless
@Local
public class NegocioImpl implements Negocio {

    @PersistenceContext(unitName = "ACOESPU")
    private EntityManager em;
    
    @Override
    public void aceptarBeca() {
        
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public void registrar(Usuario u) {
        em.persist(u);
    }

    @Override
    public Usuario iniciarSesion(Usuario u) {
        Usuario user = em.find(Usuario.class, u.getUsername());
        return user;
    }
    
    public void agnadirSocio(Socio s) {
        em.persist(s);
    }
    
    public void solicitarApadr(Apadrinamiento a) {
        em.persist(a);
    }

}
