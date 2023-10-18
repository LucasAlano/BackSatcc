package com.satc.com.satc.Model;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_item")
public class ItemVendavel extends EntityId {
    @Column(name = "descricao", nullable = true)
    private String descricao;
    @Column(name = "valorUnitario", nullable = true)
    private Double valorUnitario;
    @Column(name = "estocavel", nullable = true)
    private Boolean estocavel;

    /**Getters**/
    public String getDescricao() {
        return descricao;
    }

    public Double getValorUnitario() {
        return valorUnitario;
    }

    public Boolean getEstocavel() {
        return estocavel;
    }

    /** Setters **/
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setValorUnitario(Double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public void setEstocavel(Boolean estocavel) {
        this.estocavel = estocavel;
    }
}

