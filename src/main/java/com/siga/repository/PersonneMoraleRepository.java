package com.siga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.siga.domain.PersonneMorale;
@Repository
public interface PersonneMoraleRepository extends JpaRepository<PersonneMorale, Long> {

}
