package com.fiap.veiculos.infrastructure.persistence.persistence;

import com.fiap.veiculos.infrastructure.persistence.entity.VendaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendaSpringDataRepository extends JpaRepository<VendaEntity, String> {
}
