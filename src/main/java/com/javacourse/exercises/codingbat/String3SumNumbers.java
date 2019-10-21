package com.javacourse.exercises.codingbat;

public class String3SumNumbers {
	public int sumNumbers(String str) {
		int result = 0;
		String[] numbers = str.split("(\\D+)");
		for (String number : numbers) {
			if (!number.isBlank()) {
				result += Integer.parseInt(number);
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		String3SumNumbers app = new String3SumNumbers();
		System.out.println(app.sumNumbers("sdas11etetr23hghg"));
	}
}
