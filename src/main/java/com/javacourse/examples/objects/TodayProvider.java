package com.javacourse.examples.objects;

import java.util.Calendar;
import java.util.Date;

public class TodayProvider {
	private Date today;

	public Date getToday() {
		if (today == null) {
			return new Date();
		} else {
			return today;
		}
	}

	void fixToday(int year, int month, int day) {
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.set(year, month, day);
		today = calendar.getTime();
	}
}
