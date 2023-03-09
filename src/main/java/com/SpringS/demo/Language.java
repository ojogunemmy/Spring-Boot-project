package com.SpringS.demo;

public class Language {
	
	/*
	 * POJO -Plain old java
	 * 
	 * Language class
	 * 
	 * This class specifies and gives the user of this API
	 * a capability to delete a specific language in the choices of languages
	 * a person can use
	 * 
	 * lang--> the languages a person uses
	 * action--> the kind of action to perform on the languages current allowed action in V1 is the DELETE action
	 * 
	 */
	
	String lang;
	String action;
	
	public Language(String lang,String action) {
		this.lang=lang;
		this.action = action;
	}

	public String getLang() {
		return lang;
	}
	public void setLang(String action) {
		this.action = action;
	}


	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}
	
}
