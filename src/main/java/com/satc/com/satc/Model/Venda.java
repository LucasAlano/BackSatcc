package com.satc.com.satc.Model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Venda extends EntityId implements OperacaoFinanceira{

    @Column(name = "dt_venda")
    private LocalDate dataVenda;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
    @Column(name = "forma_pagamento")
    private FormaPagamento formaPagamento;
    @Column(name = "observacao")
    private String observacao;

    @OneToMany(mappedBy = "venda", cascade = CascadeType.ALL)
    private List<ItemVenda> itens = new ArrayList<>();


    /** Getters **/
    public LocalDate getDataVenda() {
        return dataVenda;
    }

    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public String getObservacao() {
        return observacao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<ItemVenda> getItens() {
        return itens;
    }

    /** Setters **/
    public void setDataVenda(LocalDate dataVenda) {
        this.dataVenda = dataVenda;
    }

    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void addItemVenda(ItemVenda item) {

        item.setVenda(this);
        this.itens.add(item);
    }

    /** Deleta Lista vendas **/
    public void dellItemVenda(ItemVenda item) {
        this.itens.remove(item);
    }


    @Override
    public LocalDate getDataOperacao() {
        return this.getDataVenda();
    }

    @Override
    public Double getValorTotalOperacao() {
        return this.getItens().stream().mapToDouble(ItemVenda::getValorCalculado).sum();
    }

    @Override
    public TipoOperacao getTipoOperacao() {
        return TipoOperacao.CREDITO;
    }


}
