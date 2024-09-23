package com.fiap.veiculos.infrastructure.config;

import com.fiap.veiculos.application.gateway.VeiculoRepositoryGateway;
import com.fiap.veiculos.application.usecase.veiculo.CadastrarVeiculoUseCase;
import com.fiap.veiculos.application.usecase.veiculo.CadastrarVeiculoUseCaseImpl;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
