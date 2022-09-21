package com.siga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.siga.domain.Lettrage;
@Repository
public interface LettrageRepository extends JpaRepository<Lettrage, Long> {

}
