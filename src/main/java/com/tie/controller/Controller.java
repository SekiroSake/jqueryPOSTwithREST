package com.tie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tie.domain.Word;

import com.tie.service.WordService;

@RestController
@RequestMapping("/words")
public class Controller {
	private WordService wordService;
	
	@Autowired
	public Controller(WordService wordService){
		this.wordService = wordService;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public Iterable<Word> list(){
		return wordService.list();
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public Word create(@RequestBody Word word){
		return wordService.create(word);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public Word Cap(@PathVariable(value="id") long id){
		return wordService.Cap(id);
	}
	
	
}
