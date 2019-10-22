package com.javacourse.examples;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class ExceptionExample {

	public static void main(String[] args) throws FileNotFoundException  {
		ExceptionExample app = new ExceptionExample();
		// app.firstMethod();
		// app.thirdMethod();
		// app.fourthMethod();
		app.fifthMethod();
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
//				//System.err.println(e.getMessage());
//				e.printStackTrace();
//				System.err.flush();
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
		arr[index] = value;
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

	private void fourthMethod() throws FileNotFoundException {
		FileReader fr = new FileReader("PROVA.TXT");
		// leggerò il contenuto del file
	}

	private void fifthMethod() {
		sixthMethod();
	}
	
	/**
	 * 
	 * @throws RuntimeException Nel caso in cui il file non venga trovato.
	 */
	private void sixthMethod() throws RuntimeException {
		try {
			FileReader fr = new FileReader("PROVA.TXT");
		} catch (FileNotFoundException e) {
			throw new RuntimeException("Il file non è stato trovato", e);
		}
	}
	
}
