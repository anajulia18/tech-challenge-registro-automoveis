package com.fiap.veiculos.application.usecase.veiculo;

import com.fiap.veiculos.application.gateway.VeiculoRepositoryGateway;
import com.fiap.veiculos.domain.Veiculo;
import org.springframework.stereotype.Service;

@Service
public class CadastrarVeiculoUseCaseImpl implements CadastrarVeiculoUseCase{

    private final VeiculoRepositoryGateway veiculoRepositoryGateway;

    public CadastrarVeiculoUseCaseImpl(VeiculoRepositoryGateway veiculoRepositoryGateway) {
        this.veiculoRepositoryGateway = veiculoRepositoryGateway;
    }

    public void execute(Veiculo veiculoDomain) {
        veiculoRepositoryGateway.save(veiculoDomain);
    }
}
