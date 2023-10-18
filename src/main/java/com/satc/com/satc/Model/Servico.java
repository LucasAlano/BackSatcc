package com.satc.com.satc.Model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("servico")
public class Servico extends ItemVendavel {

    @Column(name = "quantidadeHoras", nullable = true)
    private Double quantidadeHoras;

    public Servico(){
    }

    /** Construtor **/
    public Servico(String descricao, Double quantidadeHoras, Double valor) {
        super.setDescricao(descricao);
        this.quantidadeHoras = quantidadeHoras;
        super.setValorUnitario(valor);
    }

    /** Getters **/
    public Double getQuantidadeHoras() {
        return quantidadeHoras;
    }


    /** Setters **/

    public void setQuantidadeHoras(Double quantidadeHoras) {
        this.quantidadeHoras = quantidadeHoras;
    }

    @Override
    public Boolean getEstocavel() {
        return false;
    }

    @Override
    public String toString() {
        return "Servico{" +
                "Descrição" + super.getDescricao() +
                "quantidadeHoras=" + quantidadeHoras +
                " valor venda " + super.getValorUnitario() +
                '}';
    }
}

