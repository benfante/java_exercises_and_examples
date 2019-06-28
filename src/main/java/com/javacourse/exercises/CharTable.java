package com.javacourse.exercises;

import java.util.Formatter;

public class CharTable {

	public static void main(String[] args) {
		CharTable charTable = new CharTable();
		charTable.print();
	}

	
	
	
	
	
	
	
	
	String table;

	public CharTable() {
		this.buildTable();
	}
	
	public void print() {
		System.out.println(table);
	}
	
	
	
	private void buildTable() {
		StringBuilder result = new StringBuilder();
		for (char c = 'a'; c <= 'z'; c++) {
			appendRow(result, c);
			result.append('\n');
		}
		this.table = result.toString();
	}

	String buildTableString() {
		StringBuilder result = new StringBuilder();
		for (char c = 'a'; c <= 'z'; c++) {
			result.append(buildRow(c)).append('\n');
		}
		return result.toString();
	}
	
	String buildRow(char lowercased) {
		char uppercased = toUppercase(lowercased);
		String result = "'"+lowercased+"' = "+(int)lowercased+"\t'"+uppercased+"' = "+(int)uppercased;
		return result;
	}

	private char toUppercase(char lowercased) {
		return (char)(lowercased-'a'+'A');
	}
	
	
	
	
	
	
	
	
	
	
	
	
	void appendRow(StringBuilder sb, char c) {
		Formatter formatter = new Formatter(sb);
		char uppercased = toUppercase(c);
		formatter.format("'%c' = %3d    '%c' = %3d", c, (int)c, uppercased, (int)uppercased);
		formatter.close();
	}

}
