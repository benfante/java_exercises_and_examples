package com.javacourse.examples.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StringSortingExample {
	public static void main(String[] args) {
		List<String> l = new ArrayList<String>();
		l.add("Zorro");
		l.add("BIANCO");
		l.add("Bianchi");
		l.add("Verdi");
		l.add("Rossi");
		System.out.println(l);
		Collections.sort(l);
		System.out.println(l);
		
		String s1 = "Bianchi";
		String s2 = "Zorro";
		System.out.println(s1.compareTo(s2));
		
		Collections.sort(l, new StringIgnoreCaseComparator());
		System.out.println(l);
		
		Collections.sort(l, new StringLengthComparator());
		System.out.println(l);
	}	
}
