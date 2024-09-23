package com.fiap.veiculos.application.usecase.cliente;

import com.fiap.veiculos.application.gateway.ClienteRepositoryGateway;
import com.fiap.veiculos.domain.Cliente;
import org.springframework.stereotype.Component;

@Component
public class CadastrarClienteUseCaseImpl implements CadastrarClienteUseCase{

    private final ClienteRepositoryGateway clienteRepositoryGateway;

    public CadastrarClienteUseCaseImpl(ClienteRepositoryGateway clienteRepositoryGateway) {
        this.clienteRepositoryGateway = clienteRepositoryGateway;
    }

    @Override
    public void execute(Cliente cliente) {
        clienteRepositoryGateway.save(cliente);
    }
}
