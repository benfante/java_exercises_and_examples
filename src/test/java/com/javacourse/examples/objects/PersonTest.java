package com.javacourse.examples.objects;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.Test;

class PersonTest {

	@Test
	void testGetFullName() {
		Person person = new Person("Mario", "Rossi");
		String expected = "Mario Rossi";
		String result = person.getFullName();
		assertEquals(expected, result);
	}

	@Test
	void testGetAgeWithoutBirthDate() {
		Person person = new Person("Mario", "Rossi");
		int expected = -1;
		int result = person.getAge();
		assertEquals(expected, result);
	}

	@Test
	void testGetAgeWithBirthDate() {
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.set(1980, 10, 27);
		Person person = new Person("Mario", "Rossi", calendar.getTime());
		person.todayProvider.fixToday(2019, 10, 27);
		int expected = 39;
		int result = person.getAge();
		assertEquals(expected, result);
	}
	
	@Test
	void testIsBirthDate() {
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.set(1980, 10, 27);
		Person person = new Person("Mario", "Rossi", calendar.getTime());
		calendar.set(2019, 10, 27);
		Date today = calendar.getTime();
		boolean result = person.isBirthDate(today);
		assertTrue(result);
	}

	@Test
	void testToStringWithoutBirthDate() {
		Person person = new Person("Mario", "Rossi");
		String expected = "Mario Rossi";
		String result = person.toString();
		assertEquals(expected, result);
	}

	@Test
	void testToStringWithBirthDate() {
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.set(1980, 10, 27);
		Person person = new Person("Mario", "Rossi", calendar.getTime());
		String expected = "Mario Rossi ("+person.getAge()+")";
		String result = person.toString();
		assertEquals(expected, result);
	}
}
