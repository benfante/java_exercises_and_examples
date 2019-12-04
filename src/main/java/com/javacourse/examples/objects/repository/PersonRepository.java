package com.javacourse.examples.objects.repository;

import java.util.List;

import com.javacourse.examples.objects.Person;

public interface PersonRepository {
	Person save(Person person);
	Iterable<Person> findAll();
	List<Person> findAllOrderByLastNameAndFirstName();
}
