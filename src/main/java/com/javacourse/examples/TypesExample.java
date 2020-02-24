package com.javacourse.examples;

public class TypesExample {
	
	@SuppressWarnings("unused")
	public static void integerTypes() {
		int a = 2000000000;
		System.out.println(a);
		long b = 12L*a;
		long c = 12;
		int d = (int)24_000_000_000L;
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
		byte e = 12;
		byte e0 = 3;
		byte f = (byte)(e0*e);
		byte g0 = 100;
		byte g = (byte)(e*f/g0);
	}

	public static void charType() {
		char a = 'a';
		System.out.println(a);
		char b = 65; // = 'A'
		System.out.println(b);
		b = (char)(b + 1);
		System.out.println(b);
		int aCode = a;
		System.out.println(aCode);
	}
	
	public static void booleanType() {
		boolean a = true;
		System.out.println(a);
		boolean b = !a;
		System.out.println(b);
		
		int n = 15;
		if (n == 10) {
			System.out.println("s�, n � 10");
		} else {
			System.out.println("no, non lo �");			
		}
	}
	
	public static void main(String[] args) {
//		integerTypes();
//		charType();
		booleanType();
	}

}
