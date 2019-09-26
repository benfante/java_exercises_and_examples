package com.javacourse.examples.collections;

import java.util.Comparator;

public class StringLengthComparator implements Comparator<String> {

	private boolean ascending = true;
	private StringIgnoreCaseComparator sicc = new StringIgnoreCaseComparator();
	
	public StringLengthComparator() {
	}

	public StringLengthComparator(boolean ascending) {
		this.ascending = ascending;
	}

	@Override
	public int compare(String o1, String o2) {
		int result = o1.length() - o2.length();
		if (result == 0) {
			// result = o1.compareToIgnoreCase(o2);
			result = sicc.compare(o1, o2);
		}
		if (!ascending) {
			result = -result;
		}
		return result;
	}

}
