package com.javacourse.examples.objects;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class PersonApp {
	Person[] archive = new Person[0];
	private static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

	public Person readPerson(Scanner scan) {
		System.out.print("Nome: ");
		String firstName = scan.nextLine();
		System.out.print("Cognome: ");
		String lastName = scan.nextLine();
		System.out.print("Data di nascita (gg/mm/aaaa): ");
		String birthDateString = scan.nextLine();
		while (!birthDateString.isBlank() && !checkDate(birthDateString)) {
			System.out.print("Data di nascita (gg/mm/aaaa): ");
			birthDateString = scan.nextLine();
		}
		Person person = null;
		if (!birthDateString.isBlank()) {
			Date birthDate = parseDate(birthDateString);
			person = new Person(firstName, lastName, birthDate);
		} else {
			person = new Person(firstName, lastName);				
		}
		return person;
	}

	boolean checkDate(String birthDateString) {
		try {
			dateFormat.parse(birthDateString);
		} catch (ParseException e) {
			return false;
		}
		return true;
	}
	
	/**
	 * 
	 * @param birthDateString
	 * @return
	 * @throws IllegalArgumentException If the birth date string is not parseable. It should be checked in advance.
	 */
	Date parseDate(String birthDateString) throws IllegalArgumentException {
		Date birthDate = null;
		try {
			birthDate = dateFormat.parse(birthDateString);
		} catch (ParseException e) {
			throw new IllegalArgumentException("birthDateString is not valid, must be checked in advance", e);
		}
		return birthDate;
	}
	
	public void addPerson(Person person) {
		archive = Arrays.copyOf(archive, archive.length + 1);
		archive[archive.length - 1] = person;
	}

	public void printArchive() {
		Date today = new Date();
		System.out.println("*************************************");
		System.out.println("*** People");
		System.out.println("*************************************");
		for (Person person : archive) {
			System.out.print(person);
			if (person.isBirthDate(today)) {
				System.out.print(" (Happy BirthDay)");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		PersonApp personApp = new PersonApp();
		Scanner scan = new Scanner(System.in);
		do {
			System.out.print("Vuoi inserire una persona? (s/n) ");
			String again = scan.nextLine();
			if (!"s".equalsIgnoreCase(again))
				break;
			Person person = personApp.readPerson(scan);
			personApp.addPerson(person);
			
			if (person.getAge() != null) {
				System.out.println("Questa persona ha "+person.getAge().get()+" anni");
			}
			if (person.getAge().isPresent()) {
				int nextAge = person.getAge().get() + 1;
				System.out.println("L'anno prossimo avrà " + nextAge + " anni");
			}
		} while (true);
		
		personApp.printArchive();
		
		scan.close();
	}

}
