package com.siga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.siga.domain.Devise;
@Repository
public interface DeviseRepository extends JpaRepository<Devise, Long> {

}
