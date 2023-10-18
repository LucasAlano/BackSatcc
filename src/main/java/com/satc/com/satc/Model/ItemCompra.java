package com.satc.com.satc.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ItemCompra extends EntityId{
    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;
    @Column(name = "valor_unitario")
    private Double  valorUnitario;
    @Column(name = "quantidade")
    private Double  quantidade;
    @Column(name = "desconto")
    private Double  desconto;

    @ManyToOne
    @JoinColumn(name = "compra_id")
    private Compra compra;



    /** Getters **/

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

    public Compra getCompra() {
        return compra;
    }



    /** Setters **/
    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    public Double getValorCalculado() {
        double valorTotal = this.getValorUnitario() * this.getQuantidade();
        double descontoCalculado = valorTotal * ( this.getDesconto() / 100 ) ;
        return valorTotal - descontoCalculado;
    }
    public ItemCompra(Produto produto, Double valorUnitario, Double quantidade, Double desconto) {
        this.produto = produto;
        this.valorUnitario = valorUnitario;
        this.quantidade = quantidade;
        this.desconto = desconto;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }
}
