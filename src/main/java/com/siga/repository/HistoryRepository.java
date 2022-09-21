package com.siga.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.siga.domain.History;
@Repository
public interface HistoryRepository extends JpaRepository<History, Long> {

	 @Query("select u from History u where u.demande.idDemande = :id ")
	List<History> findHistoryByIdDemande(@Param("id") Long id);
}
