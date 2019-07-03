package com.javacourse.exercises.codingbat;

/**
 * Solution of the exercise sameEnds from codingbat.com
 * https://codingbat.com/prob/p131516
 * 
 * @author Lucio Benfante
 *
 */
public class SameEnds {
	public String sameEnds(String str) {
		int startLeft = 0;
		int startRight = (str.length() / 2) + (str.length() % 2);
		outer: while (startRight < str.length()) {
			int i = 0;
			while (i + startRight < str.length()) {
				if (str.charAt(startLeft + i) != str.charAt(startRight + i)) {
					startRight++;
					continue outer;
				}
				i++;
			}
			return str.substring(0, i);
		}
		return "";
	}
}
