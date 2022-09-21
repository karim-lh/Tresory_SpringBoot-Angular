package com.siga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.siga.domain.Demande;
@Repository
public interface DemandeRepository extends JpaRepository<Demande, Long> {

}
