package com.javacourse.examples.objects.repository;

public class RepositoryFactory {

	public static PersonRepository getPersonRepository() {
		return new CsvFilePersonRepository();
	}
}
