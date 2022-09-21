package com.siga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.siga.domain.PersonnePhysique;
@Repository
public interface PersonnePhysiqueRepository extends JpaRepository<PersonnePhysique, Long> {

}
