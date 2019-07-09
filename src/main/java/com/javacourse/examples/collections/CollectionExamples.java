package com.javacourse.examples.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

public class CollectionExamples {
	public static void main(String[] args) {
		Collection<String> c = new ArrayList<>();
		int a = 1;
		String s1 = "" + a;
//		String s1 = "1";
		c.add(s1);
		c.add("Lucio");
		c.add("topolino");

		Collection<String> toRemove = new LinkedList<>();
		for (String s : c) {
			System.out.println(s.toLowerCase());
			if (s.length() == 1) {
				toRemove.add(s);
			}
		}
		c.removeAll(toRemove);

		System.out.println(c);

		String s2 = "1";
//		c.remove(s2);
		
		System.out.println(c);
		
		System.out.println(s1 == s2);
		System.out.println(s1.equals(s2));
		
		c.add("2");
		c.add("pippo");
		c.add("pluto");
		System.out.println(c);
		Iterator<String> it = c.iterator();
		while(it.hasNext()) {
			String s = it.next();
			System.out.println(s);
			if (s.length() == 1) {
				it.remove();
			}
		}
		System.out.println(c);
	}
}
