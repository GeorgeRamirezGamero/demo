package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Person;

/*
 Repository: è l’ultima classe di componenti che possiamo trovare 
 in un progetto Spring. Si tratta degli oggetti dedicati al recupero 
 dei dati da una generica sorgente (DB, file, REST service). 
 Si tratta di un componente fondamentale a cui Spring ha dedicato un 
 intero progetto spin-off: Spring Data. Le classi che 
 si occupano dell’accesso ai dati sono identificate dall’annotazione @Repository.
 * */

//@Repository("fakeDao")
@Component("fakeDao")
public class FakePersonDataAccessService implements PersonDao{

	private static List<Person> DB = new ArrayList<>();
	
	@Override
	public int insertPerson(UUID id, Person person) {
		if (id == null) {id = UUID.randomUUID();}
		DB.add(new Person(id, person.getName()));
		
		return 0;
	}

	@Override
	public List<Person> getSelectAllPeople() {
		return DB;
		//ARRAY DB CON TUTTE LE PERSONE CHE SONO MEMORIZZATE
	}

	@Override
	public String deletePersonById(UUID id) {
		String response = "Non ci sono Pf con l'id Specificato";
		List<Person>DBAppo = new ArrayList<Person>();
		DBAppo.addAll(DB);
		for (Person person : DBAppo) {
			if (id.equals(person.getId())) {
				DB.remove(person);
				response = "Delete Success";
			}
		}
		return response;
		
	}

	@Override
	public String updatePersonById(UUID id, Person personInput) {
		String response = "Non ci sono Pf con l'id Specificato";
		for (Person person : DB) {
			if (id.equals(person.getId())) {
				int index = DB.indexOf(person);
				DB.remove(index);
				Person newPerson = new Person(id, personInput.getName());
				DB.add(newPerson);
				response = "Update Success";
			}
		}
		return response;
	}

	@Override
	public Person getPersonById(UUID id) {

		Person response = null;
		for (Person person : DB) {
			if (id.equals(person.getId())) {
				response = person;
			}
		}
		return response;
	}
	
	

}
