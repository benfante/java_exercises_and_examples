package com.javacourse.exercises.base;

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
	}

}
