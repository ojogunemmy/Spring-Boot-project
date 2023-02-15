package com.SpringS.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustormerService {

	
	
	@Autowired
	private CustomerRepository repo;
	

	public List<Person> getAllData(){	
		
		return repo.findAll();
	
	}
	public void addPersons(Persons person) {
		
		person.getAll().forEach(
				each->{
					repo.save(each);
				}
				);
	}

	public void addPerson(Person person) {
		repo.save(person);
	}

	public Optional<Person> getOnePerson(int id) {
		

		return repo.findById(id);
		
	}
	
	public void delete(int id) {
		
		repo.deleteById(id);

		
	}
	
	public void EditPerson() {
		
	}



}
