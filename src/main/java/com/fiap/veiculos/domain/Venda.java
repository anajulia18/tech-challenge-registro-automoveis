package com.fiap.veiculos.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Venda {

    private Cliente cliente;
    private Veiculo veiculo;
    private BigDecimal valorPago;
    private LocalDate dataDaVenda;

    public Venda(Cliente cliente, Veiculo veiculo, BigDecimal valorPago, LocalDate dataDaVenda) {
        this.cliente = cliente;
        this.veiculo = veiculo;
        this.valorPago = valorPago;
        this.dataDaVenda = dataDaVenda;
    }

    public Venda() {}
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

    public LocalDate getDataDaVenda() {
        return dataDaVenda;
    }

    public void setDataDaVenda(LocalDate dataDaVenda) {
        this.dataDaVenda = dataDaVenda;
    }
}
