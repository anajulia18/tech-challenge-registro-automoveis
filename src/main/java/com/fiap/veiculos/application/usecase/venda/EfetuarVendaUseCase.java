package com.fiap.veiculos.application.usecase.venda;

import com.fiap.veiculos.domain.Veiculo;
import com.fiap.veiculos.domain.Venda;

public interface EfetuarVendaUseCase {
    public void execute(Venda venda);
}
