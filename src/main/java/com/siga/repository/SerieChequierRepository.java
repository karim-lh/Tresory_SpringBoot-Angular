package com.siga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.siga.domain.SerieChequier;
@Repository
public interface SerieChequierRepository extends JpaRepository<SerieChequier, Long> {

}
