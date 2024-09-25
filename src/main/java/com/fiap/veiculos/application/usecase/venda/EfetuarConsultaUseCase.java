package com.fiap.veiculos.application.usecase.venda;

import com.fiap.veiculos.domain.Venda;

public interface EfetuarConsultaUseCase {
    public Venda execute(String uuid);
}
