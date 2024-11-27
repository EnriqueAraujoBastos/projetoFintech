package br.com.fiap.fintech.model;

import java.sql.Date;

public class Investimento {
    private int id;
    private String descricao;
    private Double valor;
    private String categoria;
    private String tipo;
    private Date data;

    public Investimento(int id, String descricao, double valor, String categoria, String tipo, Date data) {
        this.id = id;
        this.descricao = descricao;
        this.valor = valor;
        this.categoria = categoria;
        this.tipo = tipo;
        this.data = data;


    }
    public Investimento(String descricao, double valor, String categoria, String tipo, Date data) {

        this.descricao = descricao;
        this.valor = valor;
        this.categoria = categoria;
        this.tipo = tipo;
        this.data = data;
    }


    public Investimento() {
    }



    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValor() {
        return valor;
    }
    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getTipo() {
        return tipo;
    }
    public void setTipo(String nome) {
        this.tipo = tipo;
    }

    public Date getData() {
        return data;
    }
    public void setData(Date data) {
        this.data = data;
    }
}