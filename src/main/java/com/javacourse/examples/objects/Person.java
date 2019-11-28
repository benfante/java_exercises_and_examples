package com.javacourse.examples.objects;

import java.util.Calendar;
import java.util.Date;

public class Person {
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
	
	public int getAge() {
		if (this.birthDate == null) {
			return -1;
		} else {
			Date today = todayProvider.getToday();
			long passedTime = today.getTime() - this.birthDate.getTime();
			int years = (int)(passedTime / (365*24*60*60*1000L));
			return years;
		}
	}
	
	public boolean isBirthDate(Date today) {
		Calendar todayCal = Calendar.getInstance();
		todayCal.setTime(today);
		Calendar birthDateCal = Calendar.getInstance();
		birthDateCal.setTime(birthDate);
		return todayCal.get(Calendar.MONTH) == birthDateCal.get(Calendar.MONTH) &&
				todayCal.get(Calendar.DATE) == birthDateCal.get(Calendar.DATE);
	}
	
	public String toString() {
		if (birthDate == null) {
			return getFullName();
		} else {
			return getFullName() + " (" + getAge() + ")";
		}
	}
}
