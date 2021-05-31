package com.javacourse.exercises.codingbat;

public class AlarmClock {
	
	public static boolean isWeekend(int day) {
		if (day == 0 || day == 6) {
			return true;
		}
		return false;
	}

	public static String alarmClock(int day, boolean vacation) {
		if (isWeekend(day) && !vacation) {
			return "10:00";
		}
		if (!isWeekend(day) && !vacation) {
			return "7:00";
		}
		if (!isWeekend(day) && vacation) {
			return "10:00";
		}
		return "off";
	}

	public static void main(String[] args) {
		System.out.println(alarmClock(1, false)); // -> "7:00"
	}

}
