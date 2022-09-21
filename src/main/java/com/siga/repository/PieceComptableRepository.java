package com.siga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.siga.domain.PieceComptable;
@Repository
public interface PieceComptableRepository extends JpaRepository<PieceComptable, Long> {

}
