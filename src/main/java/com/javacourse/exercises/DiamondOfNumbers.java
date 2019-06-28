package com.javacourse.exercises;

public class DiamondOfNumbers {

	public static void main(String[] args) {
		int size = 7;
		printDiamond(size);
	}

	private static void printDiamond(int size) {
		for(int i = 1; i <= size; i++) {
			printDiamondLine(size, i);
		}
		for(int i = size-1; i >= 1; i--) {
			printDiamondLine(size, i);
		}
	}

	private static void printDiamondLine(int size, int i) {
		printInitialSpaces(size, i);
		printLeftSide(i);
		printRightSide(i);
		System.out.println();
	}

	private static void printRightSide(int i) {
		for (int j = 1; j <= i; j++) {
			System.out.print(j);
		}
	}

	private static void printLeftSide(int i) {
		for (int j = i; j > 1; j--) {
			System.out.print(j);
		}
	}

	private static void printInitialSpaces(int size, int i) {
		for (int j = 1; j <= size - i; j++) {
			System.out.print(' ');
		}
	}

}
