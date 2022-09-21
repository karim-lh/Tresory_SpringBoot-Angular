package com.siga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.siga.domain.Employe;
@Repository
public interface EmployeRepository extends JpaRepository<Employe, Long> {

}
