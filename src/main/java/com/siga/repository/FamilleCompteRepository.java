package com.siga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.siga.domain.FamilleCompte;
@Repository
public interface FamilleCompteRepository extends JpaRepository<FamilleCompte, Long> {

}
