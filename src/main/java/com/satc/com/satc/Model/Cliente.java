package com.satc.com.satc.Model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Cliente extends Pessoa{

    @Column(name = "cpf", nullable = true)
    private String cpf;
    @Column(name = "rg", nullable = true)
    private String rg;

    /** getters **/
    public String getCpf() {
        return cpf;
    }

    public String getRg() {
        return rg;
    }

    /** setters **/
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    @Override
    public String getDocumentoPrincipal() {
        return this.getCpf();
    }
}
