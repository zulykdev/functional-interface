package com.brixton.functional.optional;

import java.util.Optional;

import com.brixton.functional.repo.Person;
import com.brixton.functional.repo.PersonRepository;

public class OptionalExample {

	public static void main(String[] args) {
		//System.out.println("Result :"+myName("John"));
		Optional<String> name = Optional.ofNullable(myName("John"));
		//String name1 = Optional.ofNullable(myName("John")).get();
		//System.out.println(name.isPresent() ? name.get():"No Data Found");
		//System.out.println("Person Name :"+personName(new Person()));		
		Optional<String> personname = personNameWithOptional(PersonRepository.getPersonOptional());
		System.out.println("The Optional Person Name is :"+personname.get());
		
	}
	
	static String myName(String name) {
		return name;		
	}
	
	static String personName(Person per) {
		if(per!=null)
			return per.getName();
		else
			return "No Data Found";				
	}
	
	static Optional<String> personNameWithOptional(Optional<Person> per){
		if(per.isPresent())
			return per.map(Person :: getName);
		else
			return Optional.empty();
	}

}
