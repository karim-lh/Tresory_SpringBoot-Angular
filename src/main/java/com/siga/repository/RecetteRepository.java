package com.siga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.siga.domain.Recette;
@Repository
public interface   RecetteRepository extends JpaRepository<Recette, Long> {

}
