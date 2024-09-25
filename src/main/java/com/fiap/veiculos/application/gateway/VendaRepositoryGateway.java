package com.fiap.veiculos.application.gateway;

import com.fiap.veiculos.domain.Cliente;
import com.fiap.veiculos.domain.Venda;

public interface VendaRepositoryGateway {
    public void save(Venda venda);

    Venda findById(String uuid);
}
