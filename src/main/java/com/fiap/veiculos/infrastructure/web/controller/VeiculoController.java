package com.fiap.veiculos.infrastructure.web.controller;

import com.fiap.veiculos.application.usecase.veiculo.CadastrarVeiculoUseCase;
import com.fiap.veiculos.application.usecase.veiculo.EditarVeiculoUseCase;
import com.fiap.veiculos.application.usecase.veiculo.ListarVeiculosPorStatusUseCase;
import com.fiap.veiculos.domain.Status;
import com.fiap.veiculos.domain.Veiculo;
import com.fiap.veiculos.infrastructure.web.api.VeiculoAPI;
import com.fiap.veiculos.infrastructure.web.commands.EditarVeiculoCommand;
import com.fiap.veiculos.infrastructure.web.commands.VeiculoCadastroCommand;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VeiculoController implements VeiculoAPI {
    private final CadastrarVeiculoUseCase cadastrarVeiculoUseCase;
    private final ListarVeiculosPorStatusUseCase listarVeiculosPorStatusUseCase;
    private final EditarVeiculoUseCase editarVeiculoUseCase;

    @Autowired
    private ModelMapper modelMapper;

    public VeiculoController(CadastrarVeiculoUseCase cadastrarVeiculoUseCase, ListarVeiculosPorStatusUseCase listarVeiculosPorStatusUseCase, EditarVeiculoUseCase editarVeiculoUseCase) {
        this.cadastrarVeiculoUseCase = cadastrarVeiculoUseCase;
        this.listarVeiculosPorStatusUseCase = listarVeiculosPorStatusUseCase;
        this.editarVeiculoUseCase = editarVeiculoUseCase;
    }

    @Override
    public ResponseEntity<?> save(VeiculoCadastroCommand command) {
        Veiculo veiculoDomain = modelMapper.map(command, Veiculo.class);

        try {
            cadastrarVeiculoUseCase.execute(veiculoDomain);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @Override
    public ResponseEntity<?> findByStatus(String status) {
        try {
            var veiculos = listarVeiculosPorStatusUseCase.listarVeiculos(Status.from(status));
            return ResponseEntity.ok(veiculos);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @Override
    public ResponseEntity<?> edit(EditarVeiculoCommand command) {
        Veiculo veiculo = modelMapper.map(command, Veiculo.class);
        try {
            editarVeiculoUseCase.execute(veiculo);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
