package com.javacourse.examples;

import java.util.Arrays;

import com.javacourse.examples.inheritance.A;

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

	public static void main(String[] args) {
//		mixValues();
		enlargeArray();
	}
}
