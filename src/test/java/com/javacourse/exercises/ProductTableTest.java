package com.javacourse.exercises;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

public class ProductTableTest {

	@Test
	public void testBuildTable() {
		int[][] expected = new int[][]
				{ { 1, 2, 3 },
				  { 2, 4, 6 },
				  { 3, 6, 9 } };
		ProductTable instance = new ProductTable(3);
		int[][] result = instance.buildTable(3);
		assertArrayEquals(expected, result);
	}

	@Test
	public void testBuildTableString3() {
		String expected =
				"1   2   3  \n" +
				"2   4   6  \n" +
				"3   6   9  ";
		ProductTable instance = new ProductTable(3);
		int[][] table = instance.buildTable(3);
		String result = instance.buildTableString(table);
		assertEquals(expected, result);
	}

	@Test
	public void testBuildTableString4() {
		String expected =
				"1   2   3   4  \n" +
				"2   4   6   8  \n" +
				"3   6   9   12 \n" +
				"4   8   12  16 ";
		ProductTable instance = new ProductTable(3);
		int[][] table = instance.buildTable(4);
		String result = instance.buildTableString(table);
		assertEquals(expected, result);
	}

	@Test
	public void testProduct2x3() {
		ProductTable instance = new ProductTable(3);
		assertEquals(6, instance.product(2, 3));
	}
	
	@Test
	public void testProductOutOfTable() {
		ProductTable instance = new ProductTable(3);
		assertEquals(20, instance.product(4, 5));
	}
	
	@Test
	public void testPrint() {
		String expected =
				"1   2   3  \n" +
				"2   4   6  \n" +
				"3   6   9  "+System.getProperty("line.separator");

		PrintStream original = System.out;
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(stream, true));
		
		ProductTable instance = new ProductTable(3);
		instance.print();
		assertEquals(expected, stream.toString());
		
		System.setOut(original);
	}
}
