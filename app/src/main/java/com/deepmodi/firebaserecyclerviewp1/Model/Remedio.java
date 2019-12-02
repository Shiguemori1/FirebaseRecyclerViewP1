package com.deepmodi.firebaserecyclerviewp1.Model;

public class Remedio {

    private String nome;
    private String descricao;

    public Remedio() {
    }

    public Remedio(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
