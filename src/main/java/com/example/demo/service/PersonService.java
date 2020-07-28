package com.example.demo.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.dao.PersonDao;
import com.example.demo.model.Person;

/*
 Service: in un progetto Spring, la logica di business è gestita tramite oggetti 
 di tipo Service. Questa tipologia di componenti è identificata dall’annotazione 
 @Service ed ha la funzione di elaborare i dati e di fornirli ai Controller per 
 essere esposti verso il client. Allo stesso tempo, le informazioni da salvare 
 vengono inviate allo strato di accesso ai dati
 * */

@Service
public class PersonService {
	
	private final PersonDao personDao;
	
	/*@Autowired
	 Serve a non dover dichiarare nel XML la propietà che stiamo inserendo 
	 in questo caso per la classe PersonDao. Quindi serve a specificare
	 che un parametro sta per essere aggiunto alla nostra classe. 
	 Esempio nella classe PersonService inseriamo PersonDao quindi mettiamo 
	 Autowired sopra il nostro costruttore, puo essere messa pure sopra il parametro
	 che stiamo inserendo, comunque nel setter. 
	 */
	
	/*
	 @Qualifier: Serve a specificare quale classe dobbiamo iniettare, ad esempio
	 Se abbiamo un itenrfaccia che ha piu implementazioni, con Qualifier andiamo a 
	 specificare (con l'id della classe) quale implementazione di quella interfaccia
	 vogliamo inserire. 
	 Infatti a riga 20 di FakePersonDaoService che implementa una PersonDao abbiamo s
	 specificato L'id della nostra classe. Attenzione FakePersonDao estende 
	 l'interfaccia PersonDao quindi può essereconsiderato anche un PersonDao 
	 * */
	
	//ATTENZIONE... La stringa POSTGRESS è la stringa univoca che distringue i vari Service che implementano PERSONDAO
	//FAKEDAO: FakePersonDataAccessService
	//POSTGRESS: PersonDataAccessService
	
	@Autowired
//	public PersonService (@Qualifier("fakeDao") PersonDao personDao) {
	public PersonService (@Qualifier("postgress") PersonDao personDao) {
		this.personDao = personDao;
	}
	
	public int addPerson (Person person) {
		UUID id = person.getId();
		return personDao.insertPerson(id, person);
		
	}
	
	public List<Person> getPerson (){
			return personDao.getSelectAllPeople();
	}
	
	public Person getPersonById (UUID id) {
		return personDao.getPersonById(id);
	}
	
	public String deletePersonById (UUID id) {
		return personDao.deletePersonById(id);	
	}
	
	public String updatePersonById (UUID id, Person person) {
		return personDao.updatePersonById(id, person);
	}


}
