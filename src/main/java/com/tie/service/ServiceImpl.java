package com.tie.service;

import java.lang.annotation.Annotation;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tie.domain.Word;
import com.tie.repository.WordRepository;

@Service
public class ServiceImpl implements WordService{

	private WordRepository wordRepository;
	
	@Autowired
	public ServiceImpl(WordRepository wordRepository){
		this.wordRepository = wordRepository;
	}
	
	@Override
	public Iterable<Word> list() {
		// TODO Auto-generated method stub
		return wordRepository.findAll();
	}

	@Override
	public Word create(Word word) {
		// TODO Auto-generated method stub
		return wordRepository.save(word);
	}

	//The function of captalization
	@Override
	public Word Cap(Long id) {
		Word word = wordRepository.findOne(id);
		
		word.setWord(word.getWord().toUpperCase());
		
		
		return wordRepository.save(word);
	}

	

	@Override
	public Word read(long id) {
		// TODO Auto-generated method stub
		return wordRepository.findOne(id);
	}

	@Override
	public Word update(long id, Word word) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		
	}

	

	

}
