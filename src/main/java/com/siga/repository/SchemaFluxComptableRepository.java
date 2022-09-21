package com.siga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.siga.domain.SchemaFluxComptable;
@Repository
public interface SchemaFluxComptableRepository extends JpaRepository<SchemaFluxComptable, Long> {

}
