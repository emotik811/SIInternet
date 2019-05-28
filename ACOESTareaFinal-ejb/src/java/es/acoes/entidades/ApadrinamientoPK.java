/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.acoes.entidades;

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
    @Column(name = "SOCIO_DNI")
    private String socioDni;
    @Basic(optional = false)
    @Column(name = "JOVEN_ID_BENEFICIARIO")
    private int jovenIdBeneficiario;

    public ApadrinamientoPK() {
    }

    public ApadrinamientoPK(String socioDni, int jovenIdBeneficiario) {
        this.socioDni = socioDni;
        this.jovenIdBeneficiario = jovenIdBeneficiario;
    }

    public String getSocioDni() {
        return socioDni;
    }

    public void setSocioDni(String socioDni) {
        this.socioDni = socioDni;
    }

    public int getJovenIdBeneficiario() {
        return jovenIdBeneficiario;
    }

    public void setJovenIdBeneficiario(int jovenIdBeneficiario) {
        this.jovenIdBeneficiario = jovenIdBeneficiario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (socioDni != null ? socioDni.hashCode() : 0);
        hash += (int) jovenIdBeneficiario;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ApadrinamientoPK)) {
            return false;
        }
        ApadrinamientoPK other = (ApadrinamientoPK) object;
        if ((this.socioDni == null && other.socioDni != null) || (this.socioDni != null && !this.socioDni.equals(other.socioDni))) {
            return false;
        }
        if (this.jovenIdBeneficiario != other.jovenIdBeneficiario) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "acoestarea1.entidades.ApadrinamientoPK[ socioDni=" + socioDni + ", jovenIdBeneficiario=" + jovenIdBeneficiario + " ]";
    }
    
}
