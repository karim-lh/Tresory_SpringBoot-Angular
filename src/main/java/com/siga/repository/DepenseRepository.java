package com.siga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.siga.domain.Depense;
@Repository
public interface DepenseRepository extends JpaRepository<Depense, Long> {

}
