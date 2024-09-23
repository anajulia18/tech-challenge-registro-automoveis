package com.fiap.veiculos.domain;

import java.math.BigDecimal;

public class Venda {

    private Cliente cliente;
    private Veiculo veiculo;
    private BigDecimal valorPago;

    public Venda(Cliente cliente, Veiculo veiculo, BigDecimal valorPago) {
        this.cliente = cliente;
        this.veiculo = veiculo;
        this.valorPago = valorPago;
    }

    public Venda() {
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public BigDecimal getValorPago() {
        return valorPago;
    }

    public void setValorPago(BigDecimal valorPago) {
        this.valorPago = valorPago;
    }
}
