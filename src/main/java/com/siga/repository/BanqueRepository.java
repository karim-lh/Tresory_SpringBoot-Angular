package com.siga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.siga.domain.Banque;
@Repository
public interface BanqueRepository extends JpaRepository<Banque, Long> {

}
