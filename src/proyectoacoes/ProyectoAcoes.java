/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoacoes;

import entidades.Apadrinamientos;
import entidades.Beca;
import entidades.Beneficiario;
import entidades.Cartas_paquetes;
import entidades.Joven;
import entidades.Socio;
import entidades.Usuario;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author Usuario
 */
public class ProyectoAcoes {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProyectoAcoesPU");
        EntityManager em = emf.createEntityManager();
        
        
        EntityTransaction tx = em.getTransaction();
        
        tx.begin();
        
        Apadrinamientos ap = new Apadrinamientos();
        Beca b = new Beca();
        Beneficiario empresa = new Beneficiario();
        Cartas_paquetes c = new Cartas_paquetes();
        Joven j = new Joven();
        Socio s = new Socio();
        Usuario admin = new Usuario();
        
        
        DateFormat formato = new SimpleDateFormat("DD/MM/YYYY");
        Date fecha_envio;
        try {
            fecha_envio = formato.parse("08/02/2019");
            
            c.setFecha_recepcion(fecha_envio);
            c.setFecha_envio(fecha_envio);
        } catch (ParseException ex) {
            Logger.getLogger(ProyectoAcoes.class.getName()).log(Level.SEVERE, null, ex);
        }
        c.setContenido("Hola padrino!!!");
        
        s.setId("12345678A");
        s.setUsername("pakillo");
        s.setMail("pakillo@gmail.com");
        s.setPassword("pako1234");
        s.setNombre("Paco");
        s.setApellidos("Roman Gutierrez");
        admin.setId("98765432Z");
        admin.setUsername("alonso98");
        admin.setPassword("alonso9876");
        admin.setMail("alonsoperez@acoes.com");
        Date fecha_solicitud;
        try {
            fecha_solicitud = formato.parse("04/04/2019");
        ap.setFecha_solicitud(fecha_solicitud);
        } catch (ParseException ex) {
            Logger.getLogger(ProyectoAcoes.class.getName()).log(Level.SEVERE, null, ex);
        }
        ap.setSocio(s);
        ap.setJoven(j);
        empresa.setNombre("PUMA");
        empresa.setDireccion("calle agua");
        empresa.setLocalidad("Malaga");
        b.setTipo("Beca San Miguel");
        b.setEstado("En Espera");
        Date fecha_peticion;
        try {
            fecha_peticion = formato.parse("04/01/2019");
        b.setFecha_peticion(fecha_peticion);
        } catch (ParseException ex) {
            Logger.getLogger(ProyectoAcoes.class.getName()).log(Level.SEVERE, null, ex);
        }
        j.setNombre("Antonio");
        j.setApellidos("quijano");
        
        List<Beca> becas = new ArrayList<>();
        becas.add(b);
        j.setBecas(becas);
        c.setEntrega(ap);
        List<Apadrinamientos> apadrinamientos = new ArrayList<>();
        apadrinamientos.add(ap);
        
        s.setApadrinamientos(apadrinamientos);
        
        j.setApadrinamientos(apadrinamientos);
        
        em.persist(ap);
        em.persist(b);
        em.persist(empresa);
        em.persist(c);
        em.persist(j);
        em.persist(s);
        em.persist(admin);
        
        tx.commit();
    }
}
