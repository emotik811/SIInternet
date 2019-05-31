/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entidades.Apadrinamiento;
import entidades.ApadrinamientoPK;
import entidades.Joven;
import entidades.Usuario;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Usuario
 */
@Stateless
@LocalBean
public class NegocioImpl implements Negocio{
    
    @PersistenceContext(unitName = "ACOESEE-ejbPU")
    private EntityManager em;

    @Override
    public void comprobarLogin(Usuario u) throws ACOESException {
        Usuario us = em.find(Usuario.class, u.getUsername());
        if(us == null) {
            throw new UsuarioNoEncontradoException();
        }
        if(!us.getPassword().equals(u.getPassword())) {
            throw new IdentificacionFallidaException();
        }
    }

    @Override
    public void registrarUsuario(Usuario u) throws ACOESException {
        Usuario us = em.find(Usuario.class, u.getUsername());
        if(us != null) {
            throw new CuentaRepetidaException();
        }
        em.persist(u);
        em.persist(u.getSocio());
    }

    @Override
    public Usuario refrescarUsuario(Usuario u) throws ACOESException {
        comprobarLogin(u);
        Usuario user = em.find(Usuario.class, u.getUsername());
        em.refresh(user);
        return user;
    }
    
    @Override
    public Usuario solicitarApadrinamiento(Apadrinamiento ap) throws ACOESException  {
        Apadrinamiento a = em.find(Apadrinamiento.class, new ApadrinamientoPK(ap.getSocio().getUsername(),-1));
        if(a != null) {
            throw new SolicitarApadrinamientoException();
        }
        Usuario u = em.find(Usuario.class, ap.getSocio().getUsername());
        u.getSocio().getApadrinamientoList().add(ap);
        Joven j = em.find(Joven.class, -1);
        ApadrinamientoPK pkap = new ApadrinamientoPK();
        pkap.setJovenIdJoven(j.getIdJoven());
        pkap.setSocioUsername(u.getUsername());
        ap.setApadrinamientoPK(pkap);
        j.getApadrinamientoList().add(ap);
        Usuario us = refrescarUsuario(u);
        em.refresh(j);
        em.persist(ap);
        return us;
    }
    
    public List<Apadrinamiento> consultarApadrinamiento(String username) {
        Usuario u = em.find(Usuario.class, username);
        return u.getSocio().getApadrinamientoList();
    }
    
    public List<Apadrinamiento> getAllApadrinamientos() {
        Query q = em.createQuery("SELECT a FROM Apadrinamiento a");
        return q.getResultList();
    }
    
    public void asignarApadrinamiento(Apadrinamiento apa, Joven joven) {
        Apadrinamiento ap = em.find(Apadrinamiento.class, apa.getApadrinamientoPK());
        ap.setJoven(joven);
        ap.setFechaConfirmacion(new Date());
        ap.getJoven().getApadrinamientoList().add(ap);
        ap.getSocio().getApadrinamientoList().add(ap);
        em.refresh(ap);
    }
    
    public void añadirJoven(Joven j) {
        em.persist(j);
    }
    
    public List<Joven> getAllJovenes() {
        Query q = em.createQuery("SELECT j FROM Joven j WHERE j.idJoven <> -1");
        return q.getResultList();
    }
}
