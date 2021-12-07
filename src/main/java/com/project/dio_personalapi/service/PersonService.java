package com.project.dio_personalapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dio_personalapi.entities.MessageResponseDTO;
import com.project.dio_personalapi.entities.Person;

import Repository.PersonRepository;

@Service
public class PersonService {
	
	private PersonRepository personRepository;
	
	@Autowired
	public PersonService(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}
	
	public MessageResponseDTO createPerson(Person person) {
		Person savedPerson = personRepository.save(person);
		return MessageResponseDTO
				.builder()
				.message("Created person with ID " + savedPerson.getId())
				.build();
	}
}
