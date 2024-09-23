package com.fiap.veiculos.application.usecase.veiculo;

import com.fiap.veiculos.application.gateway.VeiculoRepositoryGateway;
import com.fiap.veiculos.domain.Status;
import com.fiap.veiculos.domain.Veiculo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ListarVeiculosPorStatusUseCaseImpl implements ListarVeiculosPorStatusUseCase {

    private final VeiculoRepositoryGateway veiculoRepositoryGateway;

    public ListarVeiculosPorStatusUseCaseImpl(VeiculoRepositoryGateway veiculoRepositoryGateway) {
        this.veiculoRepositoryGateway = veiculoRepositoryGateway;
    }

    @Override
    public List<Veiculo> listarVeiculos(Status status) {
        return veiculoRepositoryGateway.findByStatus(status);
    }
}
