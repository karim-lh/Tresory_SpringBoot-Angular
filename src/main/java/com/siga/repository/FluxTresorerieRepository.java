package com.siga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.siga.domain.FluxTresorerie;
@Repository
public interface FluxTresorerieRepository extends JpaRepository<FluxTresorerie, Long> {

}
