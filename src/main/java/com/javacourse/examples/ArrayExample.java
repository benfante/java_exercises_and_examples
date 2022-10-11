package com.javacourse.examples;

import java.util.Arrays;

public class ArrayExample {

	public static void mixValues() {
		Integer[] arr = new Integer[]{ 1, 2, 3, 4 };
		Object[] arrObject = arr;
		arrObject[0] = "Pippo";
	}
	
	public static void enlargeArray() {
		int a[] = new int[] {1, 2, 3, 4};
		// int b[] = new int[5];
		// for (int i = 0; i< a.length; i++) {
		// 	b[i] = a[i];
		// }
		// a = b;
		a = Arrays.copyOf(a, 5);
		a[4] = 5;
		System.out.println(Arrays.toString(a));
	}



	public void simpleArray() {
		int a1 = 12;
		int a2 = 13;
		int a3 = 23;
		int a4 = 54;
		int a5 = 4;

		int media = (a1 + a2 + a3 + a4 + a5)/5;

		int[] a = new int[] {12, 13, 23, 54, 4};

		int sum = 0;
		for(int i = 0; i < a.length; i++) {
			sum += a[i];
		}
		int m = sum / a.length;
	}


	public void stringArray() {
		String[] months = new String[] {
			"Gennaio", "Febbraio", "Marzo", "Aprile", "Maggio"
		};
		months[5] = "Giugno"; // ArrayIndexOutOfBoundsException
		System.out.println(months[0].toUpperCase());
	}

	public static void main(String[] args) {
//		mixValues();
		enlargeArray();
	}
}
