package com.tie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tie.domain.Word;

public interface WordRepository extends JpaRepository<Word, Long>{
	
}

