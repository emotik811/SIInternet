/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entidades.Apadrinamiento;
import entidades.ApadrinamientoPK;
import entidades.Envio;
import entidades.Joven;
import entidades.Usuario;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    @Override
    public List<Apadrinamiento> consultarApadrinamiento(String username) {
        Usuario u = em.find(Usuario.class, username);
        List<Apadrinamiento> ap = new ArrayList<>();
        for(Apadrinamiento a : u.getSocio().getApadrinamientoList()) {
            if(a.getFechaFin() == null && a.getJoven().getIdJoven()!=-1) ap.add(a);
        }
        return ap;
    }
    @Override
    public List<Apadrinamiento> getAllApadrinamientos() {
        Query q = em.createQuery("SELECT a FROM Apadrinamiento a");
        return q.getResultList();
    }
    @Override
    public void asignarApadrinamiento(Apadrinamiento apa, Joven joven) throws ACOESException{
        
        Joven j = em.find(Joven.class, joven.getIdJoven());
        Apadrinamiento ap = em.find(Apadrinamiento.class, apa.getApadrinamientoPK());
        Apadrinamiento apad = em.find(Apadrinamiento.class, new ApadrinamientoPK(apa.getApadrinamientoPK().getSocioUsername(),joven.getIdJoven()));
        if(apad != null) {
            throw new ACOESException();
        }
        Apadrinamiento apn = new Apadrinamiento();
        apn.setJoven(j);
        apn.setSocio(ap.getSocio());
        
        
        apn.setFechaConfirmacion(new Date());
        apn.getJoven().getApadrinamientoList().add(apn);
        apn.getSocio().getApadrinamientoList().add(apn);
        ApadrinamientoPK pk1 = new ApadrinamientoPK();
        pk1.setJovenIdJoven(apn.getJoven().getIdJoven());
        pk1.setSocioUsername(apn.getSocio().getUsername());
        apn.setApadrinamientoPK(pk1);
        apn.setFechaSolicitud(ap.getFechaSolicitud());
        em.persist(apn);
        em.remove(ap);
    }
    @Override
    public void añadirJoven(Joven j) {
        em.persist(j);
    }
    @Override
    public List<Joven> getAllJovenes() {
        Query q = em.createQuery("SELECT j FROM Joven j WHERE j.idJoven <> -1");
        return q.getResultList();
    }
    @Override
    public void eliminarJoven(Joven j) {
        Joven jo = em.find(Joven.class, j.getIdJoven());
        em.remove(jo);
    }
    
    @Override
    public Boolean isApadrinado(Joven j) {
        String sent = "SELECT a FROM Apadrinamiento a";
        Query q = em.createQuery(sent);
        List<Apadrinamiento> ap = q.getResultList();
        for(Apadrinamiento a: ap) {
            if(a.getJoven().getIdJoven().equals(j.getIdJoven())) {
                if(a.getFechaFin() == null && a.getFechaConfirmacion() != null) return true;
                break;
            }
        }
        return false;
    }
    
    @Override
    public void setFechaFin(Apadrinamiento ap) {
        Apadrinamiento a = em.find(Apadrinamiento.class, ap.getApadrinamientoPK());
        a.setFechaFin(new Date());
    }
    @Override
    public void añadirEnvio(Apadrinamiento ap, String contenido,String fecha) {
        try {
            Apadrinamiento a = em.find(Apadrinamiento.class, ap.getApadrinamientoPK());
            Envio e = new Envio();
            e.setApadrinamiento(a);
            e.setContenido(contenido);
            e.setFechaRecepcion(new Date());
            String sDate1=fecha;
            Date d=new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
            e.setFechaEnvio(d);
            a.getEnvioList().add(e);
            em.persist(e);
            em.refresh(a);
        } catch (ParseException ex) {
            Logger.getLogger(NegocioImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Envio> getEnviosUsername(String username) {
        Query q = em.createQuery("Select e from Envio e");
        List<Envio> en = q.getResultList();
        List<Envio> aux = new ArrayList();
        for(Envio e : en) {
            if(e.getApadrinamiento().getSocio().getUsername().equals(username))
                aux.add(e);
        }
        return aux;
    }
    
}
