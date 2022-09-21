package com.siga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.siga.domain.DocumentAlf;
@Repository
public interface DocumentAlfRepository extends JpaRepository<DocumentAlf,Long> {

}
