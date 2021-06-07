package com.javacourse.exercises.geometry;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DisegnoConReflection {
	List<Figura> foglio = new ArrayList<>();

	public void add(Figura f) {
		foglio.add(f);
	}

	public void print() {
		for (Descrivibile f : foglio) {
			System.out.println(f);
		}
	}

	public double calculateTotalArea() {
		double result = 0;
		for (Superficie superficie : foglio) {
			result += superficie.area();
		}
		return result;
	}

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Scanner scan = new Scanner(System.in);
		DisegnoConReflection disegno = new DisegnoConReflection();

		Class figureClass = null;
		boolean classFound = true;
		do {
			System.out.print("Quale figura? ");
			String figura = scan.nextLine();
			try {
				figureClass = Class.forName("com.javacourse.exercises.geometry." + figura);
				classFound = true;
			} catch (ClassNotFoundException e) {
				System.err.printf("Figura non trovata. (%s)\n", e.getLocalizedMessage());
				classFound = false;
			}
		} while (!classFound);
		System.out.println(figureClass.getName());
		
		Constructor[] constructors = figureClass.getConstructors();
		int parameterCount = constructors[0].getParameterCount();
		Double[] parameterValues = new Double[parameterCount];
		for (int i = 0; i < parameterValues.length; i++) {
			System.out.printf("Valore del parametro %d:", i+1);
			parameterValues[i] = scan.nextDouble();
			scan.nextLine();
		}
		Object figureObject = constructors[0].newInstance(parameterValues);
		disegno.add((Figura)figureObject);
		disegno.print();
	}
}
