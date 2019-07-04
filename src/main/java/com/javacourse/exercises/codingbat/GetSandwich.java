package com.javacourse.exercises.codingbat;

/**
 * Exercise on codingbat.com: https://codingbat.com/prob/p129952
 * 
 * @author Lucio Benfante
 *
 */
public class GetSandwich {

	public String getSandwich(String str) {
		int first = str.indexOf("bread");
		int last = str.lastIndexOf("bread");
		if (first < last) {
			return str.substring(first + 5, last);
		}
		return "";
	}
}
