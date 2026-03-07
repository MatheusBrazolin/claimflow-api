package com.matheus.claimflow.repository;

import com.matheus.claimflow.domain.entity.Sinistro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SinistroRepository extends JpaRepository<Sinistro, Long> {

}