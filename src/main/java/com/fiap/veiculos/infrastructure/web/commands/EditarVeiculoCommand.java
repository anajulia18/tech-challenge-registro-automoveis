package com.fiap.veiculos.infrastructure.web.commands;

import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.UUID;

import java.math.BigDecimal;
import java.time.LocalDate;

public class EditarVeiculoCommand {

    private String marca;

    private String modelo;

    private LocalDate ano;

    private BigDecimal value;

    @UUID(message = "UUID inválido!")
    @NotNull(message = "ID Não deve ser nulo")
    private String id;

    public EditarVeiculoCommand(String marca, String modelo, LocalDate ano, BigDecimal value, String id) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.value = value;
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public LocalDate getAno() {
        return ano;
    }

    public void setAno(LocalDate ano) {
        this.ano = ano;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
