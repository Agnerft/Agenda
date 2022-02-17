package com.makesystem.agenda2.model;

public class Aluno {
    private final String nome;
    private final String numero;
    private final String email;

    public Aluno(String nome, String numero, String email) {
        this.nome = nome;
        this.numero = numero;
        this.email = email;
    }

    @Override
    public String toString() {
        return nome;
    }
}
