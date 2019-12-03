package com.javacourse.examples.collections;

import java.util.Comparator;

public class StringIgnoreCaseComparator implements Comparator<String> {

	@Override
	public int compare(String o1, String o2) {
//		return o1.toLowerCase().compareTo(o2.toLowerCase());
		return o1.compareToIgnoreCase(o2);
	}

}
