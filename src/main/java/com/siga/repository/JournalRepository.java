package com.siga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.siga.domain.Journal;
@Repository
public interface JournalRepository extends JpaRepository<Journal, Long> {

}
