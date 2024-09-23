package com.fiap.veiculos.infrastructure.web.api;

import com.fiap.veiculos.infrastructure.web.commands.ClienteCadastroCommand;
import com.fiap.veiculos.infrastructure.web.commands.VeiculoCadastroCommand;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "/clientes")
public interface ClienteAPI {

    @Operation(summary = "Salva um Cliente",
            description = "Este endpoint salva um novo Cliente. O corpo da requisição deve conter os detalhes do Cliente a ser salvo.",
            tags = {"Cliente"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Veículo salvo com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos fornecidos"),
            @ApiResponse(responseCode = "500", description = "Erro interno do Servidor")
    })
    @PostMapping
    public ResponseEntity<?> save(@Parameter(description = "Detalhes do Cliente a ser salvo", required = true)
                                  @RequestBody
                                  @Valid
                                  @Validated ClienteCadastroCommand command);
}
