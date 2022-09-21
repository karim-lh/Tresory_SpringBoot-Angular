package com.siga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.siga.domain.TypePieceComptable;
@Repository
public interface TypePieceComptableRepository extends JpaRepository<TypePieceComptable, Long> {

}
