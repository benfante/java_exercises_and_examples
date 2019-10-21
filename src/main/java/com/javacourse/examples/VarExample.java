package com.javacourse.examples;

import java.math.BigDecimal;

public class VarExample {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		var a = new BigDecimal("10.2");
		
		int t = 20;
		var b = (t > 10)?"t è maggiore di 10":30;
		b = 40;
		System.out.println(b);
		b = "prova";
		System.out.println(b);
	}

}
