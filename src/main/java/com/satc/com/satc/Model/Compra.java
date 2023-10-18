package com.satc.com.satc.Model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Compra extends EntityId implements OperacaoFinanceira{

    @Column(name = "dt_compra")
    private LocalDate dataCompra;
    @ManyToOne
    @JoinColumn(name = "fornecedor_id")
    private Fornecedor fornecedor;
    @Column(name = "observecao")
    private String observacao;
    @OneToMany(mappedBy = "compra")
    private List<ItemCompra> itens = new ArrayList<>();

    /** Getteres **/
    public LocalDate getDataCompra() {
        return dataCompra;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public String getObservacao() {
        return observacao;
    }

    public List<ItemCompra> getItens() {
        return itens;
    }


    /** Setters **/

    public void setDataCompra(LocalDate dataCompra) {
        this.dataCompra = dataCompra;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public void setItens(List<ItemCompra> itens) {
        this.itens = itens;
    }

    @Override
    public String toString() {
        return "Compra{" +
                "dataCompra=" + dataCompra +
                ", fornecedor=" + fornecedor +
                ", observacao='" + observacao + '\'' +
                ", itens=" + itens +
                '}';
    }

    public void addCompra(ItemCompra item){
        item.setCompra(this);
        this.itens.add(item);
    }



    @Override
    public LocalDate getDataOperacao() {
        return this.getDataCompra();
    }

    @Override
    public Double getValorTotalOperacao() {
        return this.getItens().stream().mapToDouble(ItemCompra::getValorCalculado).sum();
    }

    @Override
    public TipoOperacao getTipoOperacao() {
        return TipoOperacao.DEBITO;
    }

    public void addItemCompra(ItemCompra item) {
        this.itens.add(item);
    }
}
