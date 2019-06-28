package com.javacourse.exercises;

import static org.junit.Assert.*;

import org.junit.Test;

public class CharTableTest {

	@Test
	public void testBuildRowForLetterA() {
		CharTable charTable = new CharTable();
		String row = charTable.buildRow('a');
		assertEquals("'a' = 97\t'A' = 65", row);
	}

	
	
	
	
	
	
	@Test
	public void testAppendRow() {
		CharTable charTable = new CharTable();
		StringBuilder sb = new StringBuilder();
		charTable.appendRow(sb, 'a');
		assertEquals("'a' =  97    'A' =  65", sb.toString());
	}
	
	@Test
	public void testFullTable() {
		CharTable charTable = new CharTable();
		String expected = "'a' =  97    'A' =  65\n"+
				"'b' =  98    'B' =  66\n"+
				"'c' =  99    'C' =  67\n"+
				"'d' = 100    'D' =  68\n"+
				"'e' = 101    'E' =  69\n"+
				"'f' = 102    'F' =  70\n"+
				"'g' = 103    'G' =  71\n"+
				"'h' = 104    'H' =  72\n"+
				"'i' = 105    'I' =  73\n"+
				"'j' = 106    'J' =  74\n"+
				"'k' = 107    'K' =  75\n"+
				"'l' = 108    'L' =  76\n"+
				"'m' = 109    'M' =  77\n"+
				"'n' = 110    'N' =  78\n"+
				"'o' = 111    'O' =  79\n"+
				"'p' = 112    'P' =  80\n"+
				"'q' = 113    'Q' =  81\n"+
				"'r' = 114    'R' =  82\n"+
				"'s' = 115    'S' =  83\n"+
				"'t' = 116    'T' =  84\n"+
				"'u' = 117    'U' =  85\n"+
				"'v' = 118    'V' =  86\n"+
				"'w' = 119    'W' =  87\n"+
				"'x' = 120    'X' =  88\n"+
				"'y' = 121    'Y' =  89\n"+
				"'z' = 122    'Z' =  90\n";
		assertEquals(expected, charTable.table);
	}
}
