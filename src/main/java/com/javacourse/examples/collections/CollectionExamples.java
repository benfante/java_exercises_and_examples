package com.javacourse.examples.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import com.javacourse.examples.objects.Person;

public class CollectionExamples {

	@SuppressWarnings({"unchecked", "rawtypes"})
	public Collection createCollectionWithoutGenerics() {
		Collection c = new LinkedList();
		c.add("Primo");
		c.add(Long.valueOf(10L));
		c.add("Secondo");
		c.add("Terzo");
		c.add("Quarto");
		return c;
	}

	public Collection<String> createCollection() {
		Collection<String> c = new ArrayList<>();
		c.add("Primo");
		c.add("Secondo");
		c.add("Terzo");
		c.add("Quarto");
		return c;
	}

	public List<String> createList() {
		List<String> c = new ArrayList<>();
		c.add("Primo");
		c.add("Secondo");
		c.add("Terzo");
		c.add("Quarto");
		return c;
	}

	public Set<String> createSet() {
		Set<String> c = new HashSet<>();
		c.add("Primo");
		c.add("Secondo");
		c.add("Terzo");
		c.add("Quarto");
		return c;
	}

	public Set<String> createSortedSet() {
		Set<String> c = new TreeSet<>(new StringLengthComparator());
//		Set<String> c = new TreeSet<>();
		c.add("Primo");
		c.add("Secondo");
		c.add("Terzo");
		c.add("Quarto");
		return c;
	}

	public Map<String, Person> createMap() {
		Map<String, Person> result = new HashMap<>();
		Person p1 = new Person("Lucio", "Benfante");
		result.put(p1.getLastName(), p1);
		result.put("Verdi", new Person("Giuseppe", "Verdi"));
		result.put("Bianco", new Person("Maria", "Bianco"));
		result.put("Rossi", new Person("Giovanna", "Rossi"));
		result.put("Neri", new Person("Francesco", "Neri"));
		return result;
	}

	public Map<String, Collection<Person>> createComplexMap() {
		Map<String, Collection<Person>> result = new HashMap<>();
		result.put("B", List.of(new Person("Lucio", "Benfante"), new Person("Maria", "Bianco")));
		result.put("V", List.of(new Person("Giuseppe", "Verdi")));
		result.put("R", List.of(new Person("Giovanna", "Rossi")));
		result.put("N", List.of(new Person("Francesco", "Neri")));
		return result;
	}
	
	public void usingCollection(Collection<String> c) {	
		for (String element : c) {
			System.out.println(element);
		}
		c.remove("Secondo");
		System.out.println(c);
	}
	
	public void usingCollectionWithIterator(Collection<String> c) {
		Iterator<String> it = c.iterator();
		while (it.hasNext()) {
			String value = it.next();
			System.out.println(value);
		}
	}
	

	public void removeElementFromCollection(Collection<String> c) {
		for (String element : c) {
			if (element.equalsIgnoreCase("secondo")) {
				c.remove(element);
			}
		}
		System.out.println(c);
	}
	
	public void removeElementFromCollectionWithIterator(Collection<String> c) {
		Iterator<String> it = c.iterator();
		while (it.hasNext()) {
			String element = it.next();
			if (element.equalsIgnoreCase("secondo")) {
				it.remove();
			}
		}
		System.out.println(c);
	}
	
	public void convertToArray(Collection<String> c) {
		Object[] array = c.toArray();
		System.out.println(Arrays.toString(array));
		
// 		String[] sArray = (String[])array;
		
//		Object[] oarr = new String[] {"Primo", "Secondo", "Terzo"};		
//		System.out.println(Arrays.toString(oarr));
//		oarr[0] = new BigDecimal("2.3");
	}

	public void convertToArraySpecific(Collection<String> c) {
		String[] array = c.toArray(new String[c.size()]);
		System.out.println(Arrays.toString(array));
	}	
	
	public void useList(List<String> l) {
		for (int i = 0; i < l.size(); i++) {
			System.out.println(l.get(i));
		}
	}
	
	public void useSet(Set<String> s) {
		System.out.println(s);
		boolean result = s.add("Secondo");
		System.out.println(result);
		System.out.println(s);
	}

	public void useSortedSet(Set<String> s) {
		System.out.println(s);
	}

	public void useMap(Map<String, Person> m) {
		Person p = m.get("Benfante");
		System.out.println(p);
	}

	public void useComplexMap(Map<String, Collection<Person>> m) {
		Collection<Person> p = m.get("B");
		System.out.println(p);
	}

	public static void main(String[] args) {
		CollectionExamples app = new CollectionExamples();
		
		// Collection<String> collection = app.createCollection();
		
		// app.usingCollection(collection);

		// app.removeElementFromCollectionWithIterator(collection);
		
//		app.convertToArraySpecific(collection);
		
		
		
		
//		Set<String> col = app.createSortedSet();
//		app.useSortedSet(col);

		// Map<String, Person> map = app.createMap();
		// app.useMap(map);

		Map<String, Collection<Person>> complexMap = app.createComplexMap();
		app.useComplexMap(complexMap);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	
//	public static void main(String[] args) {
//		Collection<String> c = new ArrayList<>();
//		int a = 1;
//		String s1 = "" + a;
////		String s1 = "1";
//		c.add(s1);
//		c.add("Lucio");
//		c.add("topolino");
//
//		Collection<String> toRemove = new LinkedList<>();
//		for (String s : c) {
//			System.out.println(s.toLowerCase());
//			if (s.length() == 1) {
//				toRemove.add(s);
//			}
//		}
//		c.removeAll(toRemove);
//
//		System.out.println(c);
//
//		String s2 = "1";
////		c.remove(s2);
//		
//		System.out.println(c);
//		
//		System.out.println(s1 == s2);
//		System.out.println(s1.equals(s2));
//		
//		c.add("2");
//		c.add("pippo");
//		c.add("pluto");
//		System.out.println(c);
//		Iterator<String> it = c.iterator();
//		while(it.hasNext()) {
//			String s = it.next();
//			System.out.println(s);
//			if (s.length() == 1) {
//				it.remove();
//			}
//		}
//		System.out.println(c);
//	}
}
