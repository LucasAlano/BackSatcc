package com.satc.com.satc.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ItemLocacao extends EntityId{

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;
    @Column(name = "vlr_unitario")
    private Double valorUnitario;
    @Column(name = "quantidade")
    private Double quantidade;
    @Column(name = "desconto")
    private Double desconto;

    @ManyToOne
    @JoinColumn(name = "locacao_id")
    private Locacao locacao;

    public Produto getProduto() {
        return produto;
    }

    public Double getValorUnitario() {
        return valorUnitario;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public Double getDesconto() {
        return desconto;
    }

    public Locacao getLocacao() {
        return locacao;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public void setValorUnitario(Double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    public void setDesconto(Double desconto) {
        this.desconto = desconto;
    }

    public void setLocacao(Locacao locacao) {
        this.locacao = locacao;
    }

    @Override
    public String toString() {
        return "ItemLocacao{" +
                "produto=" + produto +
                ", valorUnitario=" + valorUnitario +
                ", quantidade=" + quantidade +
                ", desconto=" + desconto +
                '}';
    }

    public Double getValorCalculado() {
        double valorTotal = this.getValorUnitario() * this.getQuantidade();
        double descontoCalculado = valorTotal * ( this.getDesconto() / 100 ) ;
        return valorTotal - descontoCalculado;
    }

    public ItemLocacao(Produto produto, Double valorUnitario, Double quantidade, Double desconto) {
        this.produto = produto;
        this.valorUnitario = valorUnitario;
        this.quantidade = quantidade;
        this.desconto = desconto;
    }


}
