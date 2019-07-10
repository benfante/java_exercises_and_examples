package com.javacourse.exercises.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class NamePersonMap {

	public static void main(String[] args) {
		Collection<Person> people = new ArrayList<>(); 
		people.add(new Person("Lucio", "Benfante", 18));
		people.add(new Person("Mario", "Rossi", 21));
		people.add(new Person("Giuseppe", "Verdi", 48));
		people.add(new Person("Carlo", "Bianchi", 21));
		people.add(new Person("Maria", "Neri", 18));
		people.add(new Person("Luca", "Bianco", 35));
		
		
		
		
		
		Map<String, Person> peopleIndex = new HashMap<>();
		
		for (Person person : people) {
			String key = person.getFirstName()+" "+person.getLastName();
			peopleIndex.put(key, person);
		}
		
		Person p = peopleIndex.get("Carlo Bianchi");
		System.out.println(p);
		
		Person p1 = peopleIndex.get("Nicola Vergara");
		System.out.println(p1);
	}

}
