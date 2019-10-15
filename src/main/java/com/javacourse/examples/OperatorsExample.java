package com.javacourse.examples;

public class OperatorsExample {
	public static void arithmeticOperators() {
		int a = 12;
		a++; // a = a + 1;
		System.out.println(a);
		a--; // a = a - 1;
		System.out.println(a);
		++a;
		System.out.println(a);
		--a;
		System.out.println(a);
		System.out.println(a++);
		System.out.println(a);
		System.out.println(++a);
		System.out.println(a);
		
		a += 4; // a = a + 4;
		System.out.println(a);
		
		long l = 8L;
		a = (int)(a + l);
		a += l;
	}
	
	public static void comparaisonOperators() {
		int a = 10, b = 20;
		System.out.println(a == b);
		System.out.println(a < b);
		System.out.println(a > b);
		System.out.println(a <= b);
		System.out.println(a >= b);
		System.out.println(a != b);
	}
	
	public static void logicOperators() {
		System.out.println("logic AND (&&)");
		System.out.println((true) && (true));
		System.out.println((true) && (false));
		System.out.println((false) && (true));		
		System.out.println((false) && (false));
		System.out.println("logic OR (||)");
		System.out.println((true) || (true));
		System.out.println((true) || (false));
		System.out.println((false) || (true));		
		System.out.println((false) || (false));
		System.out.println("logic XOR (^)");
		System.out.println((true) ^ (true));
		System.out.println((true) ^ (false));
		System.out.println((false) ^ (true));		
		System.out.println((false) ^ (false));
		System.out.println("logic NOT (!)");
		System.out.println(!true);
		System.out.println(!false);
		
		
		int a = 10, b = 20;
		if (a == 10 | b++ == 25) {
			// something
		}
		System.out.println(a);
		System.out.println(b);
			
	}
	
	public static void passingAString(String s) {
		if (s != null && s.length() > 3) {
			// La stringa "Lucio" è lunga 5 caratteri
			System.out.println((((("La stringa \"" + s) + "\" è\nlunga \u26AA") + s.length()) + " caratteri"));
		}
	}
	
	public static void main(String[] args) {
//		arithmeticOperators();
//		comparaisonOperators();
//		logicOperators();
		passingAString("Lucio");
	}
}
