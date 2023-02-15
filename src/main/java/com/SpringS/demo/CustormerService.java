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
	
	private Persons pers;
	
	
	
	
	private List<Person> persons=new ArrayList<Person>(List.of(
			new Person(1,"Emmanuel",List.of("Java","HTML","JavaScript","Python","CSS","Go")),
			new Person(2,"Berry",List.of("Java")),
			new Person(3,"John",List.of("HTML","JavaScript","CSS")),
			new Person(4,"Victory",List.of("HTML","JavaScript","Python")),
			new Person(5,"France",List.of("Python","CSS","Go"))
			

			));
	
	

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
