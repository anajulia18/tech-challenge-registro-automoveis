package com.fiap.veiculos.infrastructure.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "tb_cliente")
public class ClienteEntity {

    @Id
    private String id;

    private String cpf;

    @OneToMany(mappedBy = "cliente")
    private List<VendaEntity> vendaEntity;

    public ClienteEntity(String id, String cpf, List<VendaEntity> vendaEntity) {
        this.id = id;
        this.cpf = cpf;
        this.vendaEntity = vendaEntity;
    }

    public ClienteEntity() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public List<VendaEntity> getVendaEntity() {
        return vendaEntity;
    }

    public void setVendaEntity(List<VendaEntity> vendaEntity) {
        this.vendaEntity = vendaEntity;
    }
}
