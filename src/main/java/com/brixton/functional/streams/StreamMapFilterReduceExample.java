package com.brixton.functional.streams;

import com.brixton.functional.repo.Person;
import com.brixton.functional.repo.PersonRepository;

import java.util.function.Predicate;

public class StreamMapFilterReduceExample {
	
	static Predicate<Person> p1 = (per) -> per.getHeight() >=140 ;
	static Predicate<Person> p2 = (per) -> per.getGender().equals("Male");

	public static void main(String[] args) {
		int kidsCount = PersonRepository.getAllPersons()
		.stream()
		.filter(p1.and(p2))
		.map(Person :: getKids)
		//.reduce(0,Integer :: sum);
		.reduce(0, (x,y) -> (x+y));
		System.out.println("Number of Kids :"+kidsCount);
	}

}
