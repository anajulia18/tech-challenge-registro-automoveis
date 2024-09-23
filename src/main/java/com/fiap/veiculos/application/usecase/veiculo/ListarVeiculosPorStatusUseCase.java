package com.fiap.veiculos.application.usecase.veiculo;

import com.fiap.veiculos.domain.Status;
import com.fiap.veiculos.domain.Veiculo;

import java.util.List;

public interface ListarVeiculosPorStatusUseCase {
    public List<Veiculo> listarVeiculos(Status status);
}
