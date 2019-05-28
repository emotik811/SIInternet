/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import es.acoes.entidades.Apadrinamiento;
import es.acoes.entidades.Socio;
import es.acoes.entidades.Usuario;
import javax.ejb.Local;

/**
 *
 * @author Usuario
 */
@Local
public interface Negocio {

    public void aceptarBeca();

    public Usuario iniciarSesion(Usuario u);

    public void registrar(Usuario u);

    public void agnadirSocio(Socio s);

    public void solicitarApadr(Apadrinamiento a);

    
}
