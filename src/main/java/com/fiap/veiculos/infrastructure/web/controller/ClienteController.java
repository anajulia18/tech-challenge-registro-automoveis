package com.fiap.veiculos.infrastructure.web.controller;

import com.fiap.veiculos.application.usecase.cliente.CadastrarClienteUseCase;
import com.fiap.veiculos.domain.Cliente;
import com.fiap.veiculos.domain.Veiculo;
import com.fiap.veiculos.infrastructure.web.api.ClienteAPI;
import com.fiap.veiculos.infrastructure.web.commands.ClienteCadastroCommand;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClienteController implements ClienteAPI {

    private final CadastrarClienteUseCase useCase;

    @Autowired
    private ModelMapper modelMapper;

    public ClienteController(CadastrarClienteUseCase useCase) {
        this.useCase = useCase;
    }

    @Override
    public ResponseEntity<?> save(ClienteCadastroCommand command) {
        Cliente cliente = modelMapper.map(command, Cliente.class);
        try {
            useCase.execute(cliente);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
