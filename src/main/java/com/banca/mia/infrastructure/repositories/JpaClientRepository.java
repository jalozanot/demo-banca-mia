package com.banca.mia.infrastructure.repositories;


import com.banca.mia.infrastructure.entities.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaClientRepository extends JpaRepository<ClientEntity, Long> {
}
