package com.javacourse.exercises;

import java.util.Formatter;

public class ProductTable {

	private int[][] table;

	public ProductTable(int size) {
		this.table = buildTable(size);
	}

	int[][] buildTable(int size) {
		int[][] result = new int[size][size];
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				result[i][j] = (i+1)*(j+1);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		ProductTable table = new ProductTable(10);
		table.print();
		System.out.println(table.product(3, 5));
	}

	public void print() {
		print(this.table);
	}

	private void print(int[][] table) {
		System.out.println(buildTableString(table));
	}

	String buildTableString(int[][] table) {
		StringBuilder sb = new StringBuilder();
		Formatter fmt = new Formatter(sb);
		for(int i = 0; i < table.length; i++) {
			int j = 0;
			while(j < table[i].length-1) {
				fmt.format("%-3d ", table[i][j]);
				j++;
			}
			fmt.format("%-3d", table[i][j]);
			if (i < table.length - 1) {
				sb.append('\n');
			}
		}
		fmt.close();
		return sb.toString();
	}

	public int product(int a, int b) {
		int result = 0;
		if (a < this.table.length && b < this.table[a-1].length) {
			result = this.table[a-1][b-1];
		} else {
			result = a * b;
		}
		return result;
	}
	
	public void printOuput(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.printf("%5d", matrix[i][j]);
			}
			System.out.println();
		}
	}
}
