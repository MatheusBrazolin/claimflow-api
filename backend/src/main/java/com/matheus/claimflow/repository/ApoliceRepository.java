package com.matheus.claimflow.repository;

import com.matheus.claimflow.domain.entity.Apolice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApoliceRepository extends JpaRepository<Apolice, Long> {
}