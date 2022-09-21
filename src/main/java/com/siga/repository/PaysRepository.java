package com.siga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.siga.domain.Pays;
@Repository
public interface PaysRepository extends JpaRepository<Pays, Long> {

}
