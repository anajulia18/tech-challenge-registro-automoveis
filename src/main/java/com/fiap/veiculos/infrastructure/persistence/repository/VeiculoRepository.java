package com.fiap.veiculos.infrastructure.persistence.repository;

import com.fiap.veiculos.application.gateway.VeiculoRepositoryGateway;
import com.fiap.veiculos.domain.Status;
import com.fiap.veiculos.domain.Veiculo;
import com.fiap.veiculos.infrastructure.persistence.entity.VeiculoEntity;
import com.fiap.veiculos.infrastructure.persistence.persistence.VeiculoSpringDataRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class VeiculoRepository implements VeiculoRepositoryGateway {
    private final VeiculoSpringDataRepository veiculoRepository;

    @Autowired
    private ModelMapper modelMapper;

    public VeiculoRepository(VeiculoSpringDataRepository veiculoRepository) {
        this.veiculoRepository = veiculoRepository;
    }

    @Override
    public void save(Veiculo veiculo) {
        if (veiculo.getId() == null) {
            veiculo.setId(UUID.randomUUID().toString());
        }
        VeiculoEntity veiculoEntity = new VeiculoEntity(
                veiculo.getId(),
                veiculo.getMarca(),
                veiculo.getModelo(),
                veiculo.getAno(),
                veiculo.getValue(),
                veiculo.getStatus(),
                null);

        veiculoRepository.save(veiculoEntity);
    }

    @Override
    public List<Veiculo> findByStatus(Status status) {
        List<VeiculoEntity> veiculos = veiculoRepository.findByStatusOrderByValueAsc(status);

        return veiculos
                .stream()
                .map(entity -> modelMapper.map(entity, Veiculo.class))
                .collect(Collectors.toList());
    }
}
