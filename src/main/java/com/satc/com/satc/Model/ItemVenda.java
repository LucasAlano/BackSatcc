package com.satc.com.satc.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ItemVenda extends EntityId {

    @ManyToOne
    @JoinColumn(name = "produto_servico_id")
    private ItemVendavel produtoServico;

    @Column(name = "valor_unitario")
    private Double valorUnitario;
    @Column(name = "quantidade")
    private Double quantidade;
    @Column(name = "desconto")
    private Double desconto;

    @ManyToOne
    @JoinColumn(name = "venda_id")
    private Venda venda;

    /** Getters **/

    public ItemVenda(ItemVendavel produtoServico) {
        this.produtoServico = produtoServico;
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

    public Venda getVenda() {
        return venda;
    }

    /** Setters **/

    public void setProdutoServico(ItemVendavel produtoServico) {
        this.produtoServico = produtoServico;
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

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    /** Adiciona Lista vendas **/


    /** To String - Usado para apresentação da classe **/
    @Override
    public String toString() {
        return "ItemVenda{" +
                " Produto =" + produtoServico +
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


    public ItemVenda(ItemVendavel produtoServico, Double valorUnitario, Double quantidade, Double desconto) {
        this.produtoServico = produtoServico;
        this.valorUnitario = valorUnitario;
        this.quantidade = quantidade;
        this.desconto = desconto;
    }


}
