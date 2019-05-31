/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entidades.Apadrinamiento;
import entidades.Envio;
import entidades.Joven;
import entidades.Usuario;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Usuario
 */
@Local
public interface Negocio {
    public void comprobarLogin(Usuario u) throws ACOESException;
    public void registrarUsuario(Usuario u) throws ACOESException;
    public Usuario refrescarUsuario(Usuario u) throws ACOESException;

    public Usuario solicitarApadrinamiento(Apadrinamiento ap) throws ACOESException ;

    public List<Apadrinamiento> consultarApadrinamiento(String username);

    public List<Apadrinamiento> getAllApadrinamientos();

    public void asignarApadrinamiento(Apadrinamiento apadrinamiento, Joven joven)throws ACOESException;

    public void añadirJoven(Joven j);

    public List<Joven> getAllJovenes();

    public void eliminarJoven(Joven j);

    public Boolean isApadrinado(Joven j);

    public void setFechaFin(Apadrinamiento ap);

    public void añadirEnvio(Apadrinamiento apadrinamiento, String contenido,String fecha);

    public List<Envio> getEnviosUsername(String username);

}