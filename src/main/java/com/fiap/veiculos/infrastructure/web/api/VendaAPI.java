package com.fiap.veiculos.infrastructure.web.api;

import com.fiap.veiculos.infrastructure.web.commands.ClienteCadastroCommand;
import com.fiap.veiculos.infrastructure.web.commands.EfetuarVendaCommand;
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

@RequestMapping(value = "/vendas")
public interface VendaAPI {

    @Operation(summary = "Registra uma venda de veículo",
            description = "Este endpoint registra uma nova venda de veículo. O corpo da requisição deve conter os detalhes do veículo e do cliente envolvidos na venda.",
            tags = {"Venda"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Venda registrada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos fornecidos"),
            @ApiResponse(responseCode = "500", description = "Erro interno do Servidor")
    })
    @PostMapping
    public ResponseEntity<?> registerSale(
            @Parameter(description = "Detalhes da venda, incluindo informações do veículo e do cliente", required = true)
            @RequestBody
            @Valid
            @Validated EfetuarVendaCommand command);
}