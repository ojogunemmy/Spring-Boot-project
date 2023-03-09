package com.SpringS.demo;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Person {
	/*
	 * Person class
	 * 
	 * Defines the data to be entered at any given prompt so it is the template for this API
	 * 
	 * Using Spring JPA it creates a database model of exactly this format
	 * id--> identity for every entry into the database generated automatically
	 * name--> Name of the individual 
	 * language--> List of languages the specified user is proficient in using
	 * 
	 * Person class defines a table with all this attributes in MySQL server.
	 * 
	 *
	 */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) 
	private int id;
    
	private String name;
	
	private List<String> language;
	
	/*
	 * Two constructor patterns
	 * 
	 * Person()
	 * Person(int id, String name, List<String> language)
	 */
	
	public Person() {
		
	}
	
	public Person(int id, String name, List<String> language) {
	
		this.id = id;
		this.name = name;
		this.language = language;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getLanguage() {
		return language;
	}
	public void setLanguage(List<String> language) {
		this.language = language;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", language=" + language + "]";
	}

}
