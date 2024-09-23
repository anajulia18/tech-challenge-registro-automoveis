package com.fiap.veiculos.infrastructure.web.api;

import com.fiap.veiculos.domain.Veiculo;
import com.fiap.veiculos.infrastructure.web.commands.VeiculoCadastroCommand;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/veiculos")
public interface VeiculoAPI {

    @Operation(summary = "Salva um veículo",
            description = "Este endpoint salva um novo veículo. O corpo da requisição deve conter os detalhes do veículo a ser salvo.",
            tags = {"Veículo"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Veículo salvo com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos fornecidos"),
            @ApiResponse(responseCode = "500", description = "Erro interno do Servidor")
    })
    @PostMapping
    public ResponseEntity<?> save(@Parameter(description = "Detalhes do veículo a ser salvo", required = true)
                                  @RequestBody
                                  @Valid
                                  @Validated VeiculoCadastroCommand command);

    @Operation(
            summary = "Encontra veículos por status",
            description = "Este endpoint retorna uma lista de veículos com base no status fornecido. " +
                    "O status deve ser uma das opções válidas, como 'A_VENDA' ou 'VENDIDO'.",
            tags = {"Veículos"}
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Veículos encontrados com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Veiculo.class))),
            @ApiResponse(responseCode = "400", description = "Status inválido fornecido"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    @GetMapping("/status")
    public ResponseEntity<?> findByStatus(@RequestParam("status") String status);
}
