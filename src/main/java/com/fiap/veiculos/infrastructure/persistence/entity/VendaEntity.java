package com.fiap.veiculos.infrastructure.persistence.entity;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "tb_venda")
public class VendaEntity {

    @Id
    private String id;

    @ManyToOne
    @JoinColumn(name = "veiculo_id")
    private VeiculoEntity veiculo;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private ClienteEntity cliente;

    @Column(name = "data_venda")
    private LocalDate dataDaVenda;

    public VendaEntity(String id, VeiculoEntity veiculo, ClienteEntity cliente, LocalDate dataDaVenda) {
        this.id = id;
        this.veiculo = veiculo;
        this.cliente = cliente;
        this.dataDaVenda = dataDaVenda;
    }

    public VendaEntity(){}
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public VeiculoEntity getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(VeiculoEntity veiculo) {
        this.veiculo = veiculo;
    }

    public ClienteEntity getCliente() {
        return cliente;
    }

    public void setCliente(ClienteEntity cliente) {
        this.cliente = cliente;
    }

    public LocalDate getDataDaVenda() {
        return dataDaVenda;
    }

    public void setDataDaVenda(LocalDate dataDaVenda) {
        this.dataDaVenda = dataDaVenda;
    }
}
