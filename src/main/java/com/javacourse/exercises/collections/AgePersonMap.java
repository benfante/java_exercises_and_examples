package com.javacourse.exercises.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AgePersonMap {

	public static void main(String[] args) {
		Collection<Person> people = new ArrayList<>(); 
		people.add(new Person("Lucio", "Benfante", 18));
		people.add(new Person("Mario", "Rossi", 21));
		people.add(new Person("Giuseppe", "Verdi", 48));
		people.add(new Person("Carlo", "Bianchi", 21));
		people.add(new Person("Maria", "Neri", 18));
		people.add(new Person("Luca", "Bianco", 35));
		
		Map<Integer, List<Person>> peopleIndex = new HashMap<>();
		
		for (Person person : people) {
			List<Person> current = peopleIndex.get(person.getAge());
			if (current == null) {
				current = new ArrayList<>();
				peopleIndex.put(person.getAge(), current);
			}
			current.add(person);
		}
		
		List<Person> p = peopleIndex.get(21);
		System.out.println(p);
	}

}
