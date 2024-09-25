package com.fiap.veiculos.application.usecase.veiculo;

import com.fiap.veiculos.application.gateway.VeiculoRepositoryGateway;
import com.fiap.veiculos.domain.Veiculo;
import org.springframework.stereotype.Service;

@Service
public class EditarVeiculoUseCaseImpl implements EditarVeiculoUseCase{
    private final VeiculoRepositoryGateway veiculoRepositoryGateway;

    public EditarVeiculoUseCaseImpl(VeiculoRepositoryGateway veiculoRepositoryGateway) {
        this.veiculoRepositoryGateway = veiculoRepositoryGateway;
    }

    @Override
    public void execute(Veiculo veiculo) {
        veiculoRepositoryGateway.edit(veiculo);
    }
}
