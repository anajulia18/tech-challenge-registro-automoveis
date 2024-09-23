package com.fiap.veiculos.infrastructure.persistence.persistence;

import com.fiap.veiculos.domain.Status;
import com.fiap.veiculos.infrastructure.persistence.entity.VeiculoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface VeiculoSpringDataRepository extends JpaRepository<VeiculoEntity, String> {

    Optional<VeiculoEntity> findById(String id);
    //List<VeiculoEntity> findByStatusOrderByValueAsc(Status status);
    List<VeiculoEntity> findByStatusOrderByValueAsc(Status status);
}
