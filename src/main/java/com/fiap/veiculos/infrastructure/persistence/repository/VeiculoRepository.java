package com.fiap.veiculos.infrastructure.persistence.repository;

import com.fiap.veiculos.application.gateway.VeiculoRepositoryGateway;
import com.fiap.veiculos.domain.Status;
import com.fiap.veiculos.domain.Veiculo;
import com.fiap.veiculos.infrastructure.exceptions.GenericException;
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

    @Override
    public void edit(Veiculo veiculo) {
        VeiculoEntity veiculoEntity = veiculoRepository.findById(veiculo.getId())
                .orElseThrow(() -> new GenericException("Veiculo nao encontrado!"));

        if (veiculo.getAno() != null) {
            veiculoEntity.setAno(veiculo.getAno());
        }

        if (veiculo.getMarca() != null) {
            veiculoEntity.setMarca(veiculo.getMarca());
        }

        if (veiculo.getModelo() != null) {
            veiculoEntity.setModelo(veiculo.getModelo());
        }

        if (veiculo.getValue() != null) {
            veiculoEntity.setValue(veiculo.getValue());
        }

        veiculoRepository.save(veiculoEntity);

    }
}
