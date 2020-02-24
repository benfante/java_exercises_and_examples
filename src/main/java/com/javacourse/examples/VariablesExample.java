package com.javacourse.examples;

public class VariablesExample {
	int a = 10;

	/* 
	 * \\u
	 */
	
	public static void localVariables() {
		int a = 20;
		System.out.println(a);
		a = 20;
		System.out.println(a);
		a = 20 / 4;
		System.out.println(a);
		a = a + 1;
		System.out.println(a);
		a = 10 / 3;
		System.out.println(a);
		// System.out.println(d);
		double d = 10.0 / 3.0;
		System.out.println(d);
		d = 10 / 3.0;
		System.out.println(d);
		a = (int)10.0;
		System.out.println(a);
		a = (int)(10.0 / 2.9);
		System.out.println(a);
		{
			System.out.println(a);
			int b = 20;
			System.out.println(b);
		}
	}
	
	public static void methodParameters(int a) {
		System.out.println(a);
		a = a + 5;
		System.out.println(a);
	}
	
	public static int attr1;
	
	public static void classAttributes() {
		System.out.println(attr1);
		int a;
		a = 5;
		System.out.println(a);
		attr1 = 50;
		System.out.println(attr1);
		int attr1 = 200;
		System.out.println(attr1);
		System.out.println(VariablesExample.attr1);
	}
	
	public int attr2 = 6;
	
	public void nonStaticMethod() {
		attr2 = attr2 + 5;
		System.out.println(attr2);
		VariablesExample.attr1 = 3;
	}
	
	public static void main(String[] args) {
//		localVariables();
		
//		int a = 5;
//		methodParameters(a);
//		System.out.println(a);
		
//		classAttributes();
//		System.out.println(attr1);

//		System.out.println(attr2);
//		nonStaticMethod();
		
		VariablesExample ve1 = new VariablesExample();
		VariablesExample ve2 = new VariablesExample();
		ve1.attr2 = 30;
		ve2.nonStaticMethod();
		System.out.println(ve1.attr2);
		System.out.println(ve2.attr2);
		
	}

}
