package com.javacourse.exercises.base;

import java.util.Arrays;

/**
 * A simple exercise for exploring String methods.
 * 
 * <b>Attention:</b> pass at least an argument to main.
 * 
 * @author Lucio Benfante
 *
 */
public class ExploreString {

	public static void main(String[] args) {
		String s = args[0];
		System.out.println("Lunghezza: "+s.length());
		System.out.println("Primo carattere: "+s.charAt(0));
		System.out.println("Ultimo carattere: "+s.charAt(s.length()-1));
		System.out.println("Maiuscolo:"+s.toUpperCase());
		System.out.println("pluto? " +
				(s.contains("pluto") ? "YES" : "NO")
		);
		System.out.println("pluto? " +
				(s.indexOf("pluto") >= 0 ? "YES" : "NO")
		);
		String[] words = s.split(" ");
		System.out.println(Arrays.toString(words));
	}

}
