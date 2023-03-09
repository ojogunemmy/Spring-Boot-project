package com.SpringS.demo;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TechService {
	/*
	 * TechService abstracts the whole process of connection to database 
	 * giving security to the details of this platform
	 */


	//repo contains the logics to perform SQL action in a simple way
	@Autowired
	private TechRepository repo;

	//Fetches all data in the database 
	public List<Person> getAllData(){	
		try {
			return repo.findAll();
		}catch(Exception e) {
			List<Person> err=new LinkedList<Person>();
			List<String> errO=new LinkedList<String>();
			errO.add("fetch error at database");
			err.add(new Person(0,"Error",errO));
			return err;
		}

	}

	//Enable user to add several persons in one click and sends statistics of action and log for each
	public LinkedHashMap<String,List<String>> addPersons(Persons person) {
		List<String> res=new LinkedList<String>();
		List<String> log=new LinkedList<String>();

		int success=0;
		int failed=0;
		try {
			
			for(Person each:person.getAll()) {
				if(repo.findById(each.getId()).isPresent()) {
					log.add(" for "+each.getName()+" remove id attached");
					failed=failed+1;

				}else {

					repo.save(each);
					log.add("for "+each.getName()+" Successfully added");
					success=success+1;
				}
			}
			
		}catch(Exception e) {
			log.add("Error at save action with spring JPA");
			log.add(e.getMessage());
		}
		

		res.add("At "+new Date().toInstant().toString()+"-- failed:"+failed+", success:"+success);

		//Actions performed and documentation on status of action set to controller
		LinkedHashMap<String, List<String>> finalResponse=new LinkedHashMap<String,List<String>>(2);
		finalResponse.put("log", log);
		finalResponse.put("statistics", res);

		return finalResponse;

	}
	
	//Adds one person to the database and also performs update action.
	public void addPerson(Person person) {
		repo.save(person);
	}

	//helps get one person based on id given
	public Optional<Person> getOnePerson(int id) {

		return repo.findById(id);

	}
	
	//Delete Action based on id
	public void delete(int id) {

		repo.deleteById(id);

	}

	public void EditPerson() {

	}



}
