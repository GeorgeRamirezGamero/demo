package com.example.demo.dao;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Person;

@Repository("postgress")
public class PersonDataAccessService implements PersonDao {

	@Override
	public int insertPerson(UUID id, Person person) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Person> getSelectAllPeople() {
		// TODO Auto-generated method stub
		return List.of(new Person(UUID.randomUUID(), "FROM POSGRESS"));
	}

	@Override
	public Person getPersonById(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deletePersonById(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updatePersonById(UUID id, Person person) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	

}
