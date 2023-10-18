package com.satc.com.satc.Model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@DiscriminatorValue("produto")
public class Produto extends ItemVendavel {

    @Column(name = "nome", length = 100, nullable = true)
    private String nome;
    @Column(name = "precoCompra", nullable = true)
    private Double precoCompra;
    @Column(name = "dataValidade", nullable = true)
    private LocalDate dataValidade;
    @Column(name = "dataPrazo", nullable = true)
    private LocalDate dataPrazo;


    /** Enum com Status**/
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;


    public Produto() {
    }

    public Produto(String nome, String descricao) {
        this.nome = nome;
        super.setDescricao(descricao);
    }

    public Produto(String nome, Double precoVenda, Double precoCompra, Status status) {
        this.nome = nome;
        super.setValorUnitario(precoVenda);
        this.precoCompra = precoCompra;
        this.status = status;
    }

    public Produto(Integer id, String nome, String descricao, Double precoVenda, Double precoCompra, LocalDate dataValidade, LocalDate dataPrazo, Status status) {
        this.nome = nome;
        super.setDescricao(descricao);
        super.setValorUnitario(precoVenda);
        this.precoCompra = precoCompra;
        this.dataValidade = dataValidade;
        this.dataPrazo = dataPrazo;
        this.status = status;
    }


    /** Getter **/


    public String getNome() {
        return nome;
    }

    public Double getPrecoCompra() {
        return precoCompra;
    }

    public LocalDate getDataValidade() {
        return dataValidade;
    }

    public LocalDate getDataPrazo() {
        return dataPrazo;
    }

    public Status getStatus() {
        return status;
    }




    /** Setter **/

    public void setNome(String nome) {
        this.nome = nome;
    }


    public void setPrecoCompra(Double precoCompra) {
        this.precoCompra = precoCompra;
    }

    public void setDataValidade(LocalDate dataValidade) {
        this.dataValidade = dataValidade;
    }

    public void setDataPrazo(LocalDate dataPrazo) {
        this.dataPrazo = dataPrazo;
    }

    public void setStatus(Status status) {
        this.status = status;
    }


    public Double calculaMargemDeLucro() {
        double lucro = super.getValorUnitario() - precoCompra;
        double margemLucro = (lucro / super.getValorUnitario()) * 100;
        return margemLucro;
    }

    public void setPrecoVenda(Double precoVenda) throws MargemLucroException {
        super.setValorUnitario(precoVenda);
        if ( this.calculaMargemDeLucro() < 20.0){
            throw new MargemLucroException();
        }
    }



    @Override
    public String toString() {
        return "Produto{" +
                "nome='" + nome + '\'' +
                ", Descrição=" + super.getDescricao() +
                ", precoCompra=" + precoCompra +
                ", preço Venda=" + super.getValorUnitario() +
                ", dataValidade=" + dataValidade +
                ", dataPrazo=" + dataPrazo +
                ", status=" + status +
                '}';
    }

}
