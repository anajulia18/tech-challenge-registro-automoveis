package com.fiap.veiculos.infrastructure.web.api;

import com.fiap.veiculos.infrastructure.web.commands.EfetuarVendaCommand;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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


    @Operation(summary = "Consulta uma venda de veículo",
            description = "Este endpoint permite consultar os detalhes de uma venda de veículo específica. O corpo da requisição deve conter o identificador da venda.",
            tags = {"Venda"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Venda encontrada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Venda não encontrada"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos fornecidos"),
            @ApiResponse(responseCode = "500", description = "Erro interno do Servidor")
    })
    @GetMapping("/{uuid}")
    public ResponseEntity<?> getSale(
            @Parameter(description = "Detalhes da venda, incluindo informações do veículo e do cliente", required = true)
            @PathVariable("uuid") String uuid);

}