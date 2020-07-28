package com.example.demo.dao;

import java.util.List;
import java.util.UUID;

import com.example.demo.model.Person;

//INTERFACCIA CON TUTTI I METODI CHE USEREMO PER INTERFARCCIARCI CON IL DB

public interface PersonDao {

	//Dati mockati
	int insertPerson(UUID id, Person person);
	
	default int addPerson (Person person) {
		UUID id = UUID.randomUUID();
		return insertPerson(id, person);
	}
	
	List<Person> getSelectAllPeople();
	
	Person getPersonById (UUID id);

	
	String deletePersonById (UUID id);
	
	String updatePersonById (UUID id, Person person);
}
