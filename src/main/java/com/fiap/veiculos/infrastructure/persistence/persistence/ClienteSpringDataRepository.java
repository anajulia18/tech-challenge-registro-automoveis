package com.fiap.veiculos.infrastructure.persistence.persistence;

import com.fiap.veiculos.domain.Cliente;
import com.fiap.veiculos.infrastructure.persistence.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteSpringDataRepository extends JpaRepository<ClienteEntity, String> {

    Optional<ClienteEntity> findById(String id);
}
