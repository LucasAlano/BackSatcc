package com.satc.com.satc.Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Balanco extends EntityId{
    private LocalDate dataBalanco;
    private String responsavel;

    private List<OperacaoFinanceira> operacoes = new ArrayList<>();

    public LocalDate getDataBalanco() {
        return dataBalanco;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public List<OperacaoFinanceira> getOperacoes() {
        return operacoes;
    }

    public void setDataBalanco(LocalDate dataBalanco) {
        this.dataBalanco = dataBalanco;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public void setOperacoes(List<OperacaoFinanceira> operacoes) {
        this.operacoes = operacoes;
    }

    public void addOperacoes(OperacaoFinanceira operacao){
        this.operacoes.add(operacao);
    }

    public void delOperacoes(OperacaoFinanceira operacao){
        this.operacoes.remove(operacao);
    }

    @Override
    public String toString() {
        return "Balanco{" +
                "dataBalanco=" + dataBalanco +
                ", responsavel='" + responsavel + '\'' +
                ", operacoes=" + operacoes +
                '}';
    }

    public Double getValorTotal(TipoOperacao tipo){
        return this.getOperacoes().stream().filter(op -> op.getTipoOperacao().equals(tipo))
                .mapToDouble(OperacaoFinanceira::getValorTotalOperacao)
                .sum();
    }
    public void imprimirBalanco() {
        System.out.println("--------------------------------------------");
        System.out.println("Balanço número: " + this.getId());
        System.out.println("Data: " + this.getDataBalanco());
        System.out.println("Responsavel: " + this.getResponsavel());
        System.out.println("--------------------------------------------");
        for (OperacaoFinanceira op : this.getOperacoes()) {
            System.out.println("Data Operação: " + op.getDataOperacao() + " Tipo operação: " + op.getTipoOperacao() + " Valor operação: " + op.getValorTotalOperacao() + " - (" + getTipoOperacao(op) + ")") ;
        }
        System.out.println("Valor total dos Debitos: " + getValorTotal(TipoOperacao.DEBITO));
        System.out.println("Valor total dos Creditos: " + getValorTotal(TipoOperacao.CREDITO));
        System.out.println("Valor total das operações: " + (getValorTotal(TipoOperacao.CREDITO) - getValorTotal(TipoOperacao.DEBITO)));
        System.out.println("---------------------------");
    }

    public String getTipoOperacao(OperacaoFinanceira operacao){
        if (operacao instanceof Compra){
            return "Compra";
        }
        if (operacao instanceof Venda) {
            return "Venda";
        }
        return "Locacao";
    }

}
