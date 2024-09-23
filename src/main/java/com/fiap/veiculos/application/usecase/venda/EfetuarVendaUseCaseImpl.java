package com.fiap.veiculos.application.usecase.venda;

import com.fiap.veiculos.application.gateway.VendaRepositoryGateway;
import com.fiap.veiculos.domain.Venda;
import org.springframework.stereotype.Component;

@Component
public class EfetuarVendaUseCaseImpl implements EfetuarVendaUseCase {

    private final VendaRepositoryGateway vendaRepositoryGateway;

    public EfetuarVendaUseCaseImpl(VendaRepositoryGateway vendaRepositoryGateway) {
        this.vendaRepositoryGateway = vendaRepositoryGateway;
    }

    @Override
    public void execute(Venda venda) {
        vendaRepositoryGateway.save(venda);
    }
}
