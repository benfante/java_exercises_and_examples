package com.javacourse.examples.objects;

import java.util.Calendar;
import java.util.Date;
import java.util.Objects;
import java.util.Optional;

public class Person implements Comparable<Person> {
	private String firstName;
	private String lastName;
	private Date birthDate;
	
	TodayProvider todayProvider = new TodayProvider();

	public Person(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Person(String firstName, String lastName, Date birthDate) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
	}
	
	public String getFullName() {
		return firstName + " " + lastName;
	}
	
	public Optional<Integer> getAge() {
		if (this.birthDate == null) {
			return Optional.empty();
		} else {
			Date today = todayProvider.getToday();
			long passedTime = today.getTime() - this.birthDate.getTime();
			int years = (int)(passedTime / (365*24*60*60*1000L));
			return Optional.of(years);
		}
	}
	
	public boolean isBirthDate(Date today) {
		if (birthDate != null) {
			Calendar todayCal = Calendar.getInstance();
			todayCal.setTime(today);
			Calendar birthDateCal = Calendar.getInstance();
			birthDateCal.setTime(birthDate);
			return todayCal.get(Calendar.MONTH) == birthDateCal.get(Calendar.MONTH) &&
					todayCal.get(Calendar.DATE) == birthDateCal.get(Calendar.DATE);
		} else {
			return false;
		}
	}
	
	@Override
	public String toString() {
		if (birthDate == null) {
			return getFullName();
		} else {
			return getFullName() + " (" + getAge() + ")";
		}
	}

	@Override
	public int compareTo(Person o) {
		// return (this.lastName+this.firstName).compareToIgnoreCase(o.lastName+o.firstName);
		int result = this.lastName.compareToIgnoreCase(o.lastName);
		if (result == 0) {
			result = this.firstName.compareToIgnoreCase(o.firstName);
		}
		return result;
	}

	@Override
	public int hashCode() {
		return Objects.hash(firstName, lastName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return Objects.equals(firstName, other.firstName) && Objects.equals(lastName, other.lastName);
	}

	public void setBirthDate(int year, int month, int day) {
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.set(year, month - 1, day);
		this.birthDate = calendar.getTime();
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public Date getBirthDate() {
		return birthDate;
	}
	
}
