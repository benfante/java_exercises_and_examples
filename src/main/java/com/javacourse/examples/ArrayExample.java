package com.javacourse.examples;

public class ArrayExample {

	public static void mixValues() {
		Integer[] arr = new Integer[]{ 1, 2, 3, 4 };
		Object[] arrObject = arr;
		arrObject[0] = 1.2;
	}
	
	public static void main(String[] args) {
		mixValues();
	}
}
