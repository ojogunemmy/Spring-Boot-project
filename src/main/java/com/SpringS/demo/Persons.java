package com.SpringS.demo;

import java.util.List;




public class Persons {
	/*
	 * POJO -Plain old java
	 * 
	 * Persons class
	 * 
	 * Allow addition of multiple persons into the Person table
	 * 
	 */
	
	private List<Person> all;
	
	public Persons() {
		
	}

	public Persons(List<Person> all) {
		super();
		this.all = all;
	}

	public List<Person> getAll() {
		return all;
	}

	public void setAll(List<Person> all) {
		this.all = all;
	}
	

	
}
