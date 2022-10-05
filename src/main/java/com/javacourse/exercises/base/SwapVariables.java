package com.javacourse.exercises.base;

public class SwapVariables {

	int b;
	int a;

	public SwapVariables(int a, int b) {
		this.a = a;
		this.b = b;
	}

	@Override
	public String toString() {
		return "a = " + a + ", b = " + b;
	}

	public void swapWithTemp() {
		int temp = a;
		a = b;
		b = temp;
	}

	public void swap() {
		a = a + b;
		b = a - b;
		a = a - b;
	}

	public static void main(String[] args) {
		SwapVariables sv1 = new SwapVariables(12, 3);
		sv1.swap();
		System.out.println(sv1);

		// int a = 12;
		// int b = 3;
		// int tmp = b;
		// b = a;
		// a = tmp;
		// System.out.println("a = " + a + " b = " + b);
	}

}
