package com.SpringS.demo;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Person {
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
    
	private String name;
	
	private List<String> language;
	
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
