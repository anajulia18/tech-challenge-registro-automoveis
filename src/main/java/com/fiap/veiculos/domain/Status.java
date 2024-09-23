package com.fiap.veiculos.domain;

import java.util.Arrays;

public enum Status {

    VENDIDO("vendido"),
    DISPONIVEL("disponivel");

    private final String nome;

    Status(String nome) {
        this.nome = nome;
    }

    public static Status from(String nome) {
        return Arrays.stream(Status.values())
                .filter(x -> x.nome.equalsIgnoreCase(nome))
                .findFirst()
                .orElse(null);
    }

    public String getNome() {
        return nome;
    }
}
