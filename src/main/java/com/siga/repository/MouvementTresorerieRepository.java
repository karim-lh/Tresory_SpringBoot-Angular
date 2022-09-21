package com.siga.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.siga.domain.MouvementTresorerie;
@Repository
public interface MouvementTresorerieRepository extends JpaRepository<MouvementTresorerie, Long> {

	List<MouvementTresorerie> findAllByTypeMouvement(String type);
}
