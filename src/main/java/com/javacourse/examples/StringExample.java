package com.javacourse.examples;

public class StringExample {
	
	public static void main(String[] args) {
		String s = "A simple simple String";
		
		String t = s.toLowerCase();
		System.out.println(t);
		System.out.println(s);
		
		System.out.println(s.charAt(9));
//		System.out.println(s.charAt(29));
		
		System.out.println(s.endsWith("g"));
		
		System.out.println(s.indexOf("simple"));
		System.out.println(s.indexOf("simple", 3));
		System.out.println(s.lastIndexOf("simple"));
		System.out.println(s.lastIndexOf("simple", 8));
		System.out.println(s.indexOf("pippo"));
		
		String k = s.replace('s', 't');
		System.out.println(k);
		
		System.out.println(s.substring(2, 10));
		
		String s1 = "Concatenate " + 2 + " different types";
		
		String s2 = "Concatenate ";
		s2 = s2 + 2;
		s2 = s2 + " different types";
		
		System.out.println(s1 == s2);
		System.out.println(s1.equals(s2));
		
		String t1 = "Lucio";
		String t2 = "Lucio";
		System.out.println(t1 == t2);
		String t3 = "Luci";
		t3 = t3+"o";
		System.out.println(t1 == t3);
	}
	
	public void stringBuilderExample() {
		StringBuilder sb = new StringBuilder("Esempio");
		sb.append(" di uso").append(" di StringBuilder"); // "Esempio di uso di StringBuilder"
	}
}
