package com.javacourse.examples.objects;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

class PersonAppTest {

	@Test
	void testReadPerson() throws ParseException {
		PersonApp app = new PersonApp();
		String input =
				"Mario\nRossi\n28/11/1980\n";
		Scanner scan = new Scanner(input);
		Person person = app.readPerson(scan);
		assertNotNull(person);
		assertEquals("Mario Rossi", person.getFullName());
	}

	@Test
	void testParseDate() throws ParseException {
		PersonApp app = new PersonApp();
		Date date = app.parseDate("28/11/1980");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		assertEquals(28, calendar.get(Calendar.DATE));
		assertEquals(10, calendar.get(Calendar.MONTH));
		assertEquals(1980, calendar.get(Calendar.YEAR));
	}

	@Test
	void testAddPerson() {
		PersonApp app = new PersonApp();
		int initialSize = app.archive.size();
		app.addPerson(new Person("Mario", "Rossi"));
		assertEquals(initialSize+1, app.archive.size());
	}

}
