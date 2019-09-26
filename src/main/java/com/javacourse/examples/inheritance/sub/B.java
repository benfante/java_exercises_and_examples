package com.javacourse.examples.inheritance.sub;

import com.javacourse.examples.inheritance.A;

public class B extends A {
	int c;

	public B(int a, int b, int c) {
		super(a, b);
		this.c = c;
	}

	public B(int c) {
		this(0, 0, c);
	}

	public B(int c, long k) {
		this.c = c;
	}
	
	@Override
	public int sum() {
		return super.sum() + c;
	}
	
	public int mean() {
		return sum() / 3;
	}
	
	@Override
	public String toString() {
		return "B [c=" + c + ", toString()=" + super.toString() + "]";
	}

	public static void main(String[] args) {
		B b = new B(1, 2, 3);
		System.out.println(b.sum());
		
		B b2 = new B(2, 3, 4);
		A a  = b2;
		
		System.out.println(b2.sum());
		System.out.println(b2.product());
		System.out.println(b2.mean());
		System.out.println(a.sum());
		System.out.println(a.product());
		// System.out.println(a.mean()); // it's not in the "interface" of A
		
		B b3 = (B)a;
		
		A a2 = giveMeNumbers();
		System.out.println(a2);
		System.out.println(a2.sum());
		if (a2 instanceof B) {
			B b4 = (B)a2;
			System.out.println(b4.mean());
		}
		
		A a3 = new B(4, 5, 6);
		System.out.println(a3.doubleSum());
	}

	private static A giveMeNumbers() {
		return new B(4, 5, 6);
//		return new A(8, 9);
	}
}
