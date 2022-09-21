package com.siga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.siga.domain.CompteTresorerie;
@Repository
public interface CompteTresorerieRepository extends JpaRepository<CompteTresorerie, Long> {

}