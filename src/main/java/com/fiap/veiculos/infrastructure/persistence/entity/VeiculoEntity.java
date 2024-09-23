package com.fiap.veiculos.infrastructure.persistence.entity;


import com.fiap.veiculos.domain.Status;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "tb_veiculo")
public class VeiculoEntity {

    @Id
    private String id;

    private String marca;

    private String modelo;

    private LocalDate ano;

    private BigDecimal value;

    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToMany(mappedBy = "veiculo")
    private List<VendaEntity> vendaEntity;

    public VeiculoEntity(String id, String marca, String modelo, LocalDate ano, BigDecimal value, Status status, List<VendaEntity> vendaEntity) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.value = value;
        this.status = status;
        this.vendaEntity = vendaEntity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<VendaEntity> getVendaEntity() {
        return vendaEntity;
    }

    public void setVendaEntity(List<VendaEntity> vendaEntity) {
        this.vendaEntity = vendaEntity;
    }

    public VeiculoEntity() {
    }
}
