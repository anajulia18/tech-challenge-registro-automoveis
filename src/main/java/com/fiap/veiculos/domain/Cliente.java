package com.fiap.veiculos.domain;

import java.util.Objects;

public class Cliente {
    private String id;
    private String cpf;

    public Cliente(String id, String cpf) {
        Objects.requireNonNull(cpf, "Cpf não pode ser nulo");
        this.cpf = cpf;
    }

    public Cliente() {
    }

    public String getId() {
        return id;
    }

    public String getCpf() {
        return cpf;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return id.equals(cliente.id) && cpf.equals(cliente.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cpf);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id='" + id + '\'' +
                ", cpf='" + cpf + '\'' +
                '}';
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
