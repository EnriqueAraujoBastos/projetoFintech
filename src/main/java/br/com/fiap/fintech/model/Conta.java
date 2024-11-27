package br.com.fiap.fintech.model;

import java.sql.Date;

public class Conta {
    private int id;
    private String nome;
    private Double saldo;
    private String tipo;
    private Date data;

    public Conta(int id, String nome, double saldo,  String tipo,  Date data) {
        this.id = id;
        this.nome = nome;
        this.saldo = saldo;
        this.tipo = tipo;
        this.data = data;
    }

    public Conta(String nome, double saldo,  String tipo,  Date data) {
        this.nome = nome;
        this.saldo = saldo;
        this.tipo = tipo;
        this.data = data;
    }


    public Conta() {
    }



    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getSaldo() {
        return saldo;
    }
    public void setValor(Double saldo) {
        this.saldo = saldo;
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