package br.com.fiap.fintech.model;

import java.sql.Date;
import java.time.LocalDate;

public class Despesa {
    private int id;
    private String descricao;
    private Double valor;
    private String categoria;
    private String tipo;
    private String origem;
    private Date data;

    public Despesa(int id, String descricao, double valor, String categoria, String tipo, String origem, Date data) {
        this.id = id;
        this.descricao = descricao;
        this.valor = valor;
        this.categoria = categoria;
        this.tipo = tipo;
        this.origem = origem;
        this.data = data;


    }
    public Despesa(String descricao, double valor, String categoria, String tipo, String origem, Date data) {

        this.descricao = descricao;
        this.valor = valor;
        this.categoria = categoria;
        this.tipo = tipo;
        this.origem = origem;
        this.data = data;
    }


    public Despesa() {
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

    public String getOrigem() {
        return origem;
    }
    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public Date getData() {
        return data;
    }
    public void setData(Date data) {
        this.data = data;
    }
}