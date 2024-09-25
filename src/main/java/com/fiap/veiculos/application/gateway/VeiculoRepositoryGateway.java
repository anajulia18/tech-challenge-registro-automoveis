package com.fiap.veiculos.application.gateway;

import com.fiap.veiculos.domain.Status;
import com.fiap.veiculos.domain.Veiculo;

import java.util.List;

public interface VeiculoRepositoryGateway {
    public void save(Veiculo veiculo);
    public List<Veiculo> findByStatus(Status status);
    public void edit(Veiculo veiculo);
}
