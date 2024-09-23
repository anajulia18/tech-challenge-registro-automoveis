package com.fiap.veiculos.infrastructure.web.commands;

import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.UUID;

import java.math.BigDecimal;

public class EfetuarVendaCommand {
    @UUID
    @NotNull(message = "ID DO VEICULO NAO PODE SER NULL")
    private String idVeiculo;


    @UUID
    @NotNull(message = "ID DO CLIENTE NAO PODE SER NULL")
    private String idCliente;

    @NotNull(message = "Valor a pagar não pode ser null")
    private BigDecimal valorPago;

    public EfetuarVendaCommand(String idVeiculo, String idCliente, BigDecimal valorPago) {
        this.idVeiculo = idVeiculo;
        this.idCliente = idCliente;
        this.valorPago = valorPago;
    }

    public EfetuarVendaCommand() {
    }

    public @UUID @NotNull(message = "ID DO VEICULO NAO PODE SER NULL") String getIdVeiculo() {
        return idVeiculo;
    }

    public void setIdVeiculo(@UUID @NotNull(message = "ID DO VEICULO NAO PODE SER NULL") String idVeiculo) {
        this.idVeiculo = idVeiculo;
    }

    public @UUID @NotNull(message = "ID DO CLIENTE NAO PODE SER NULL") String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(@UUID @NotNull(message = "ID DO CLIENTE NAO PODE SER NULL") String idCliente) {
        this.idCliente = idCliente;
    }

    public @NotNull(message = "Valor a pagar não pode ser null") BigDecimal getValorPago() {
        return valorPago;
    }

    public void setValorPago(@NotNull(message = "Valor a pagar não pode ser null") BigDecimal valorPago) {
        this.valorPago = valorPago;
    }
}
