package com.fiap.veiculos.infrastructure.web.commands;

import com.fiap.veiculos.domain.Status;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

public class VeiculoCadastroCommand {
    @NotNull(message = "Marca do veículo não pode ser null")
    private String marca;

    @NotNull(message = "Modelo do veículo não pode ser null")
    private String modelo;

    @NotNull(message = "Ano do veículo não pode ser null")
    private LocalDate ano;

    @NotNull(message = "Valor do veículo não pode ser null")
    private BigDecimal value;

    private final String status = Status.DISPONIVEL.name();

    public VeiculoCadastroCommand(String marca, String modelo, LocalDate ano, BigDecimal value) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.value = value;
    }

    public @NotNull(message = "Marca do veículo não pode ser null") String getMarca() {
        return marca;
    }

    public void setMarca(@NotNull(message = "Marca do veículo não pode ser null") String marca) {
        this.marca = marca;
    }

    public @NotNull(message = "Modelo do veículo não pode ser null") String getModelo() {
        return modelo;
    }

    public void setModelo(@NotNull(message = "Modelo do veículo não pode ser null") String modelo) {
        this.modelo = modelo;
    }

    public @NotNull(message = "Ano do veículo não pode ser null") LocalDate getAno() {
        return ano;
    }

    public void setAno(@NotNull(message = "Ano do veículo não pode ser null") LocalDate ano) {
        this.ano = ano;
    }

    public @NotNull(message = "Valor do veículo não pode ser null") BigDecimal getValue() {
        return value;
    }

    public void setValue(@NotNull(message = "Valor do veículo não pode ser null") BigDecimal value) {
        this.value = value;
    }

    public String getStatus() {
        return status;
    }
}
