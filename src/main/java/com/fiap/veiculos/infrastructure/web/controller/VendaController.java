package com.fiap.veiculos.infrastructure.web.controller;

import com.fiap.veiculos.application.usecase.cliente.CadastrarClienteUseCase;
import com.fiap.veiculos.application.usecase.venda.EfetuarVendaUseCase;
import com.fiap.veiculos.domain.Cliente;
import com.fiap.veiculos.domain.Venda;
import com.fiap.veiculos.infrastructure.web.api.ClienteAPI;
import com.fiap.veiculos.infrastructure.web.api.VendaAPI;
import com.fiap.veiculos.infrastructure.web.commands.ClienteCadastroCommand;
import com.fiap.veiculos.infrastructure.web.commands.EfetuarVendaCommand;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VendaController implements VendaAPI {

    private final EfetuarVendaUseCase efetuarVendaUseCase;

    public VendaController(EfetuarVendaUseCase efetuarVendaUseCase) {
        this.efetuarVendaUseCase = efetuarVendaUseCase;
    }

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ResponseEntity<?> registerSale(EfetuarVendaCommand command) {
        Venda vendaDomain = modelMapper.map(command, Venda.class);

        try {
            efetuarVendaUseCase.execute(vendaDomain);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
