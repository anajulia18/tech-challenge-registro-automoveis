package com.fiap.veiculos.infrastructure.persistence.repository;

import com.fiap.veiculos.application.gateway.ClienteRepositoryGateway;
import com.fiap.veiculos.domain.Cliente;
import com.fiap.veiculos.infrastructure.persistence.entity.ClienteEntity;
import com.fiap.veiculos.infrastructure.persistence.persistence.ClienteSpringDataRepository;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ClienteRepository implements ClienteRepositoryGateway {

    private final ClienteSpringDataRepository clienteSpringDataRepository;

    public ClienteRepository(ClienteSpringDataRepository clienteSpringDataRepository) {
        this.clienteSpringDataRepository = clienteSpringDataRepository;
    }

}
