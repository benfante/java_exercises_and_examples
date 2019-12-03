package com.javacourse.examples.inheritance;

public class A {
	protected final int a;
	int b;
	
	public A() {
		a = 1;
	}
	
	public A(int a, int b) {
		this.a = a;
		this.b = b;
	}
	
	public int sum() {
		return a + b;
	}
	
	public int product() {
		return a * b;
	}

	public int doubleSum() {
		return sum() * 2;
	}
	
	@Override
	public String toString() {
		return "A [a=" + a + ", b=" + b + "]";
	}
	
}
