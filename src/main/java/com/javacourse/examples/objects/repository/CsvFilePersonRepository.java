package com.javacourse.examples.objects.repository;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.javacourse.examples.objects.Person;

public class CsvFilePersonRepository implements PersonRepository {
	
	private static final String FILE_NAME = "person.dat";
	private static final File FILE_PATH = new File(System.getProperty("user.home"));

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

	private Set<Person> archive = new HashSet<>();
	
	public CsvFilePersonRepository() {
		load();
	}
	
	private void load() {
		File file = new File(FILE_PATH, FILE_NAME);
		if (file.exists()) {
			try (BufferedReader reader = new BufferedReader(new FileReader(file));) {
				String line = null;
				while ((line = reader.readLine()) != null) {
					String[] fields = line.split("\\,");
					Person person;
					if (fields.length > 2) {
						person = new Person(fields[1], fields[0], dateFormat.parse(fields[2]));
					} else {
						person = new Person(fields[1], fields[0]);						
					}
					archive.add(person);
				}
			} catch (IOException|ParseException e) {
				throw new IllegalArgumentException("Error reading data from file", e);
			}
		}
	}

	@Override
	public Person save(Person person) {
		if (archive.contains(person)) {
			archive.remove(person);
		}
		archive.add(person);
		store();
		return person;
	}

	private void store() {
		File file = new File(FILE_PATH, FILE_NAME);
		try (PrintWriter writer = new PrintWriter(new FileWriter(file));) {
			for (Person person : archive) {
				writer.printf("%s,%s,%s\n",
						person.getLastName(),
						person.getFirstName(),
						person.getBirthDate() != null ? dateFormat.format(person.getBirthDate()) : "");
			}
		} catch (IOException e) {
			throw new IllegalArgumentException("Error writing data to file", e);
		}
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
