package com.fiap.veiculos.application.gateway;

import com.fiap.veiculos.domain.Cliente;

public interface ClienteRepositoryGateway {
    void save(Cliente cliente);
}
