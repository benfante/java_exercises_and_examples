package com.javacourse.examples.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"unchecked","rawtypes"})
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
		
		Object s1 = "Bianchi";
		Object s2 = "Zorro";
		Comparable c1 = (Comparable) s1;
		Comparable c2 = (Comparable) s2;
		System.out.println(c1.compareTo(c2));
		
		Collections.sort(l, new StringIgnoreCaseComparator());
		System.out.println(l);
			
		Collections.sort(l, new StringLengthComparator());
		System.out.println(l);

		Collections.sort(l, new StringLengthComparator(false));
		System.out.println(l);
	}	
}
