package com.satc.com.satc.Model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Fornecedor extends Pessoa{

    @Column(name = "cnpg", nullable = true)
    private String cnpj;
    @Column(name = "inscricaoEstadual" +
            "", nullable = true)
    private String inscricaoEstadual;


    /** Getters **/
    public String getCnpj() {
        return cnpj;
    }

    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    /** Setters **/

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public void setInscricaoEstadual(String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }

    @Override
    public String getDocumentoPrincipal() {
        return this.getCnpj();
    }

}
