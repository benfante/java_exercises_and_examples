package com.javacourse.exercises.codingbat;

/**
 * Exercise on codingbat.com https://codingbat.com/prob/p138990
 * 
 * @author Lucio Benfante
 *
 */
public class CloseFar {
	public boolean closeFar1(int a, int b, int c) {
		if ((Math.abs(a - b) <= 1 && Math.abs(c - a) >= 2 && Math.abs(c - b) >= 2)
				|| (Math.abs(a - c) <= 1 && Math.abs(b - a) >= 2 && Math.abs(b - c) >= 2)) {
			return true;
		}
		return false;
	}

	public boolean closeFar2(int a, int b, int c) {
		if (Math.abs(c - b) >= 2
				&& ((Math.abs(a - b) <= 1 && Math.abs(c - a) >= 2) || (Math.abs(a - c) <= 1 && Math.abs(b - a) >= 2))) {
			return true;
		}
		return false;
	}

	public boolean closeFar3(int a, int b, int c) {
		int min, middle, max;
		if (a <= b && a <= c) {
			min = a;
			if (b <= c) {
				middle = b;
				max = c;
			} else {
				middle = c;
				max = b;
			}
		} else if (b <= c) {
			min = b;
			if (a <= c) {
				middle = a;
				max = c;
			} else {
				middle = c;
				max = a;
			}
		} else {
			min = c;
			if (a <= b) {
				middle = a;
				max = b;
			} else {
				middle = b;
				max = c;
			}
		}
		if (middle - min <= 1 && max - middle <= 1) {
			return false;
		}
		return true;
	}

	/**
	 * Ordering by bubble sort
	 */
	public boolean closeFar(int a, int b, int c) {
		int tmp;
		if (a > b) {
			tmp = a;
			a = b;
			b = tmp;
		}
		if (b > c) {
			tmp = b;
			b = c;
			c = tmp;
		}
		if (a > b) {
			tmp = a;
			a = b;
			b = tmp;
		}
		if (b - a <= 1 && c - b <= 1) {
			return false;
		}
		return true;
	}
}
