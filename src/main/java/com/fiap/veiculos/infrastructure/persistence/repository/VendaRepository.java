package com.fiap.veiculos.infrastructure.persistence.repository;

import com.fiap.veiculos.application.gateway.VendaRepositoryGateway;
import com.fiap.veiculos.domain.Status;
import com.fiap.veiculos.domain.Venda;
import com.fiap.veiculos.infrastructure.exceptions.GenericException;
import com.fiap.veiculos.infrastructure.persistence.entity.ClienteEntity;
import com.fiap.veiculos.infrastructure.persistence.entity.VeiculoEntity;
import com.fiap.veiculos.infrastructure.persistence.entity.VendaEntity;
import com.fiap.veiculos.infrastructure.persistence.persistence.ClienteSpringDataRepository;
import com.fiap.veiculos.infrastructure.persistence.persistence.VeiculoSpringDataRepository;
import com.fiap.veiculos.infrastructure.persistence.persistence.VendaSpringDataRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class VendaRepository implements VendaRepositoryGateway {
    private final VendaSpringDataRepository vendaSpringDataRepository;
    private final ClienteSpringDataRepository clienteSpringDataRepository;
    private final VeiculoSpringDataRepository veiculoSpringDataRepository;

    @Autowired
    private ModelMapper modelMapper;

    public VendaRepository(VendaSpringDataRepository vendaSpringDataRepository, ClienteSpringDataRepository clienteSpringDataRepository, VeiculoSpringDataRepository veiculoSpringDataRepository) {
        this.vendaSpringDataRepository = vendaSpringDataRepository;
        this.clienteSpringDataRepository = clienteSpringDataRepository;
        this.veiculoSpringDataRepository = veiculoSpringDataRepository;
    }

    @Override
    public void save(Venda venda) {
        ClienteEntity cliente = clienteSpringDataRepository.findById(venda.getCliente().getId())
                .orElseThrow(() -> new GenericException("Erro ao procurar cliente: Não existe na base de dados"));

        VeiculoEntity veiculo = veiculoSpringDataRepository.findById(venda.getVeiculo().getId())
                .orElseThrow(() -> new GenericException("Erro ao procurar veiculo: Não existe na base de dados"));

        if (venda.getValorPago().compareTo(veiculo.getValue()) != 0) {
            throw new GenericException("Valor a pagar inválido, Valor ser pago deve ser: ".concat(veiculo.getValue().toString()));
        }

        VendaEntity vendaEntity = new VendaEntity(UUID.randomUUID().toString(), veiculo, cliente, venda.getDataDaVenda());
        vendaSpringDataRepository.save(vendaEntity);

        veiculo.setStatus(Status.VENDIDO);
        veiculoSpringDataRepository.save(veiculo);

    }

    @Override
    public Venda findById(String uuid) {
        VendaEntity vendaEntity = vendaSpringDataRepository.findById(uuid).orElseThrow(() -> new GenericException("Erro ao encontrar Venda: Nao existe na base ded dados!"));

        return modelMapper.map(vendaEntity, Venda.class);
    }
}
