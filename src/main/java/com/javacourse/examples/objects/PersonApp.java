package com.javacourse.examples.objects;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class PersonApp {
	Person[] archive = new Person[0];
	private static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

	public Person readPerson(Scanner scan) throws ParseException {
		System.out.print("Nome: ");
		String firstName = scan.nextLine();
		System.out.print("Cognome: ");
		String lastName = scan.nextLine();
		System.out.print("Data di nascita (gg/mm/aaaa): ");
		String birthDateString = scan.nextLine();
		Person person = null;
		if (!birthDateString.isBlank()) {
			Date birthDate = parseDate(birthDateString);
			person = new Person(firstName, lastName, birthDate);
		} else {
			person = new Person(firstName, lastName);				
		}
		return person;
	}

	Date parseDate(String birthDateString) throws ParseException {
		Date birthDate = dateFormat.parse(birthDateString);
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
	
	public static void main(String[] args) throws ParseException {
		PersonApp personApp = new PersonApp();
		Scanner scan = new Scanner(System.in);
		do {
			System.out.print("Vuoi inserire una persona? (s/n) ");
			String again = scan.nextLine();
			if (!"s".equalsIgnoreCase(again))
				break;
			Person person = personApp.readPerson(scan);
			personApp.addPerson(person);
		} while (true);
		
		personApp.printArchive();
		
		scan.close();
	}

}
