package com.SpringS.demo;


import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@SpringBootApplication
@RequestMapping("/api/v1")


public class TechController {
	/*
	 * Controller class handles all HTTP requests and sends Response
	 * 
	 * /api/v1 -- base link to perform CRUD actions
	 * 
	 * ****End points****
	 * /all-- GET Request 
	 * /add-- POST Request
	 * /addPersons-- POST Request
	 * /all/{id} -- GET Request 
	 * /all/delete/{id} -- DELETE Request
	 * /update -- PUT Request
	 * /langUser/{speak} -- GET Request 
	 * /langUser/{id} -- DELETE Request
	 * 
	 */

	@Autowired
	private TechService serve;

	@RequestMapping(value="/all",method=RequestMethod.GET)
	public List<Person> user() {
		return serve.getAllData();

	}

	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String adminAddPerson(@RequestBody Person data) {
		if(serve.getOnePerson(data.getId()).isPresent()) {
			return "Null entry";
		}else {
			serve.addPerson(data);
			return 1+" row added";
		}


	}	
	@RequestMapping(value="/addPersons",method=RequestMethod.POST)
	public String addManyPersons(@RequestBody Persons pers) {
		LinkedHashMap<String,List<String>> log=serve.addPersons(pers);
		StringBuilder res= new StringBuilder();
		
		log.get("statistics").forEach(line->{
			res.append(line);
		});
		
		return res.toString();

	}	

	@RequestMapping(value="/all/{id}",method=RequestMethod.GET)
	public Optional<Person> getOne(@PathVariable int id) {
		return serve.getOnePerson(id);
	}

	@RequestMapping(value="/all/delete/{id}",method=RequestMethod.DELETE)
	public void delete(@PathVariable int id) {
		serve.delete(id);
	}

	@RequestMapping(value="/update",method=RequestMethod.PUT)
	public Person update(@RequestBody Person individual) {
		serve.addPerson(individual);

		int id = individual.getId();

		return  serve.getOnePerson(id).get();
	}
	
	@RequestMapping(value="/langUser/{speak}",method=RequestMethod.GET)
	public List<Person> getLanguageParticular(@PathVariable String speak) {

		LinkedList<Person> speakLang = new LinkedList<Person>();

		for(Person per:serve.getAllData()) {
			boolean present=false;
			for(String lng:per.getLanguage()) {

				if(lng.equalsIgnoreCase(speak)) {
					present=true;
				}
			}
			if(present==true) {
				speakLang.add(per);
			}
		}

		return speakLang;


	}

	@RequestMapping(value="/langUser/{id}",method=RequestMethod.DELETE)
	public Optional<Person> getSpecific(@PathVariable("id") int id, @RequestBody Language langDel) {
		/*
		 * To delete a specific language from list of languages tied to an id
		 */

		List<String> data = new ArrayList<>();
		Optional<Person> pinnedID = serve.getOnePerson(id);
		Person update = pinnedID.get();

		if(langDel.getAction().toString().equals("DELETE")) {
			List<String> languages = update.getLanguage();

			languages.forEach(each->{

				if(!each.equalsIgnoreCase(langDel.getLang())) {
					data.add(each);
				}
			});

			update.setLanguage(data);
			serve.addPerson(update);
		}
		return serve.getOnePerson(id);


	}

	public static void main(String[] args) {
		SpringApplication.run(TechController.class, args);
	}



}