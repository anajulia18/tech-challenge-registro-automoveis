package com.fiap.veiculos.infrastructure.web.controller;

import com.fiap.veiculos.application.usecase.venda.EfetuarConsultaUseCase;
import com.fiap.veiculos.application.usecase.venda.EfetuarVendaUseCase;
import com.fiap.veiculos.domain.Venda;
import com.fiap.veiculos.infrastructure.web.api.VendaAPI;
import com.fiap.veiculos.infrastructure.web.commands.EfetuarVendaCommand;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class VendaController implements VendaAPI {

    private final EfetuarVendaUseCase efetuarVendaUseCase;
    private final EfetuarConsultaUseCase efetuarConsultaUseCase;

    public VendaController(EfetuarVendaUseCase efetuarVendaUseCase, EfetuarConsultaUseCase efetuarConsultaUseCase) {
        this.efetuarVendaUseCase = efetuarVendaUseCase;
        this.efetuarConsultaUseCase = efetuarConsultaUseCase;
    }

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ResponseEntity<?> registerSale(EfetuarVendaCommand command) {
        Venda vendaDomain = modelMapper.map(command, Venda.class);
        vendaDomain.setDataDaVenda(LocalDate.now());

        try {
            efetuarVendaUseCase.execute(vendaDomain);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @Override
    public ResponseEntity<?> getSale(String uuid) {
        try {
            return ResponseEntity.ok(efetuarConsultaUseCase.execute(uuid));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}