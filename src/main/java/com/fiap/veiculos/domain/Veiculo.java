package com.fiap.veiculos.domain;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class Veiculo {

    private String id;
    private String marca;
    private String modelo;
    private LocalDate ano;
    private BigDecimal value;
    private Status status;

    public Veiculo(String id, String marca, String modelo, LocalDate ano, BigDecimal value, Status status) {
        this.id = id;
        this.marca = Objects.requireNonNull(marca, "Marca não pode ser nula");
        this.modelo = Objects.requireNonNull(modelo, "Modelo não pode ser nulo");
        this.ano = Objects.requireNonNull(ano, "Ano não pode ser nulo");
        this.value = Objects.requireNonNull(value, "Valor não pode ser nulo");
        this.status = Objects.requireNonNull(status, "Status não pode ser nulo");
    }

    public String getId() {
        return id;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public LocalDate getAno() {
        return ano;
    }

    public BigDecimal getValue() {
        return value;
    }

    public Status getStatus() {
        return status;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Veiculo veiculo = (Veiculo) o;
        return id.equals(veiculo.id) &&
                marca.equals(veiculo.marca) &&
                modelo.equals(veiculo.modelo) &&
                ano.equals(veiculo.ano) &&
                value.equals(veiculo.value) &&
                status == veiculo.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, marca, modelo, ano, value, status);
    }

    @Override
    public String toString() {
        return "Veiculo{" +
                "id='" + id + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", ano=" + ano +
                ", value=" + value +
                ", status=" + status +
                '}';
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setAno(LocalDate ano) {
        this.ano = ano;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Veiculo() {
    }
}
