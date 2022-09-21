package com.siga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.siga.domain.AgenceSociete;
@Repository
public interface AgenceSocieteRepository extends JpaRepository<AgenceSociete, Long> {

}
