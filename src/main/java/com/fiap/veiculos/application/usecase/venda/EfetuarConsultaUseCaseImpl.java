package com.fiap.veiculos.application.usecase.venda;

import com.fiap.veiculos.application.gateway.VendaRepositoryGateway;
import com.fiap.veiculos.domain.Venda;
import org.springframework.stereotype.Service;

@Service
public class EfetuarConsultaUseCaseImpl implements EfetuarConsultaUseCase {
    private final VendaRepositoryGateway vendaRepositoryGateway;

    public EfetuarConsultaUseCaseImpl(VendaRepositoryGateway vendaRepositoryGateway) {
        this.vendaRepositoryGateway = vendaRepositoryGateway;
    }

    @Override
    public Venda execute(String uuid) {
        return vendaRepositoryGateway.findById(uuid);
    }
}
