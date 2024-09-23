package com.fiap.veiculos.infrastructure.web.commands;

import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CPF;

public class ClienteCadastroCommand {

    @CPF(message = "CPF Inválido")
    @NotNull(message = "CPF Não pode ter o valor NULL")
    private String cpf;

    public ClienteCadastroCommand(String cpf) {
        this.cpf = cpf;
    }

    public @CPF(message = "CPF Inválido") @NotNull(message = "CPF Não pode ter o valor NULL") String getCpf() {
        return cpf;
    }

    public void setCpf(@CPF(message = "CPF Inválido") @NotNull(message = "CPF Não pode ter o valor NULL") String cpf) {
        this.cpf = cpf;
    }

    public ClienteCadastroCommand() {}
}
