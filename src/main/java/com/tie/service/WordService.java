package com.tie.service;

import java.util.List;

import com.tie.domain.Word;;

public interface WordService {
	Iterable<Word> list();

	Word create(Word word);
	
	//Captalize
	
	Word Cap(Long id);
	
	Word read(long id);

	Word update(long id, Word word);

	void delete(long id);
}
