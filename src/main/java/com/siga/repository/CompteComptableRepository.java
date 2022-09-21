package com.siga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.siga.domain.CompteComptable;
@Repository
public interface CompteComptableRepository extends JpaRepository<CompteComptable, Long> {

}
