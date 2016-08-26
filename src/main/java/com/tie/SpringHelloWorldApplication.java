package com.tie;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;

import com.tie.domain.Word;
import com.tie.repository.WordRepository;

@SpringBootApplication
public class SpringHelloWorldApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringHelloWorldApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(WordRepository wordRepository) {
		return args -> {
			Word word = new Word("HelloWOrld");
			wordRepository.save(word);		
		};
	}

}
