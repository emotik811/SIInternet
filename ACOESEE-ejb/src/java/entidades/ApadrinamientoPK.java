/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Usuario
 */
@Embeddable
public class ApadrinamientoPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "SOCIO_USERNAME")
    private String socioUsername;
    @Basic(optional = false)
    @Column(name = "JOVEN_ID_JOVEN")
    private int jovenIdJoven;

    public ApadrinamientoPK() {
    }

    public ApadrinamientoPK(String socioUsername, int jovenIdJoven) {
        this.socioUsername = socioUsername;
        this.jovenIdJoven = jovenIdJoven;
    }

    public String getSocioUsername() {
        return socioUsername;
    }

    public void setSocioUsername(String socioUsername) {
        this.socioUsername = socioUsername;
    }

    public int getJovenIdJoven() {
        return jovenIdJoven;
    }

    public void setJovenIdJoven(int jovenIdJoven) {
        this.jovenIdJoven = jovenIdJoven;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (socioUsername != null ? socioUsername.hashCode() : 0);
        hash += (int) jovenIdJoven;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ApadrinamientoPK)) {
            return false;
        }
        ApadrinamientoPK other = (ApadrinamientoPK) object;
        if ((this.socioUsername == null && other.socioUsername != null) || (this.socioUsername != null && !this.socioUsername.equals(other.socioUsername))) {
            return false;
        }
        if (this.jovenIdJoven != other.jovenIdJoven) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.ApadrinamientoPK[ socioUsername=" + socioUsername + ", jovenIdJoven=" + jovenIdJoven + " ]";
    }
    
}
