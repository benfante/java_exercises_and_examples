package com.javacourse.examples.objects.repository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.javacourse.examples.objects.Person;

public class InMemoryPersonRepository implements PersonRepository {
	private Set<Person> archive = new HashSet<>();
	
	@Override
	public Person save(Person person) {
		if (archive.contains(person)) {
			archive.remove(person);
		}
		archive.add(person);
		return person;
	}

	@Override
	public Iterable<Person> findAll() {
		return new ArrayList<>(archive);
	}

	@Override
	public List<Person> findAllOrderByLastNameAndFirstName() {
		List<Person> copied = new ArrayList<>(archive);
		copied.sort(null);
		return copied;
	}

}
