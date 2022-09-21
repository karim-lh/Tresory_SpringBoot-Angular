package com.siga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.siga.domain.Authority;
@Repository
public interface AuthoritieRepository extends JpaRepository<Authority, Long> {

}
