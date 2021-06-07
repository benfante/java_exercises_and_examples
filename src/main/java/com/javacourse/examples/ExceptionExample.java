package com.javacourse.examples;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class ExceptionExample {

	public static void main(String[] args) throws FileNotFoundException {
		ExceptionExample app = new ExceptionExample();
		// app.firstMethod();
		// app.thirdMethod();
		// app.fourthMethod("PROVA.TXT");
		try {
			app.fifthMethod();
		} catch (IllegalArgumentException e) {
			System.out.println("Devi controllare che il file esista!");
			e.printStackTrace(System.out);
		} catch (RuntimeException e) {
			// errore generico
		}
	}

	private void firstMethod() {
		// firstMethod();
		boolean success = false;
		int index = 15;
		while (!success) {
			try {
				this.secondMethod(index, 20);
				System.out.println("Sono arrivato qui");
				success = true;
			} catch (ArrayIndexOutOfBoundsException e) {
				System.err.println(e.getMessage());
				e.printStackTrace();
				System.err.flush();
//				System.out.println("No, sei stupido");
//				System.out.flush();
				index--;
			}
		}
	}

	private void secondMethod(int index, int value) {
		int arr[] = null;
		// arr[0] = 1;
		arr = new int[10];
		if (index < arr.length) {
			arr[index] = value;
		} else {
			throw new ArrayIndexOutOfBoundsException("Eccezione falsa");
		}
		System.out.println(Arrays.toString(arr));
	}
	
	private void thirdMethod() {
		try {
			FileReader fr = new FileReader("PROVA.TXT");
			// leggerò il contenuto del file
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.err.println("Sono nel catch di FNFE");
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("Sono nel catch di third method");
		}
	}

	private void fourthMethod(String filename) throws FileNotFoundException {
		FileReader fr = new FileReader(filename);
		// leggerò il contenuto del file
		System.out.println("Sto terminando il fourthMethod");
	}

	private void fifthMethod() {
		sixthMethod("PROVA.TXT");
	}
	
	/**
	 * 
	 * @throws IllegalArgumentException Nel caso in cui il file non venga trovato.
	 */
	private void sixthMethod(String filename) throws IllegalArgumentException { /* RuntimeException */
		try {
			FileReader fr = new FileReader(filename);
		} catch (FileNotFoundException e) {
			throw new IllegalArgumentException("Il file non è stato trovato", e);
		}
	}
	
}
