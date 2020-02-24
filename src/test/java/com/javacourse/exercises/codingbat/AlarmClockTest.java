package com.javacourse.exercises.codingbat;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AlarmClockTest {

	@Test
	void testAlarmClockOnWeekDayNoVacation() {
		assertEquals("7:00", AlarmClock.alarmClock(1, false));
	}

	@Test
	void testAlarmClockOnWeekendNoVacation() {
		assertEquals("10:00", AlarmClock.alarmClock(0, false));
	}

	@Test
	void testAlarmClockOnVacationWeekend() {
		assertEquals("off", AlarmClock.alarmClock(0, true));
	}
}
