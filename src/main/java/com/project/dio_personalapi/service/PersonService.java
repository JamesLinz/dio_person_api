package com.project.dio_personalapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dio_personalapi.entities.MessageResponseDTO;
import com.project.dio_personalapi.entities.Person;

import Repository.PersonRepository;
import dto.PersonDTO;

@Service
public class PersonService {
	
	private PersonRepository personRepository;
	
	@Autowired
	public PersonService(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}
	
	public MessageResponseDTO createPerson(PersonDTO personDTO) {
		
		Person personToSave = Person.builder()
				.firstName(personDTO.getFirstName())
				.lastName(personDTO.getLastName())
				.birthDate(personDTO.getBirthDate())
				.phones(personDTO.getPhones())
				.build();
		
		
		Person savedPerson = personRepository.save(personToSave);
		return MessageResponseDTO
				.builder()
				.message("Created person with ID " + savedPerson.getId())
				.build();
	}

	public List<PersonDTO> listAll() {
		List<Person> allPeople = personRepository.findAll();
		return allPeople.stream()
				.map(personMapper::toDTO)
				.collect(Collectors.toList());
	}
	
	public PersonDTO findById(Long id) {
		Optional<Person> optionalPerson = personalRepository.findById(id);
		if (optionalPerson.isEmpty()) {
			throw new PersonNotFoundException(id);
		}
		return personMapper.toDTO(optionalPerson.get());
	}

	public void delete(Long id) {
		personRepository.findById(id)
		.orElseThrow(() -> new PersonNotFoundException(id));
		
		personRepository.deleteById(id);
	}
}
