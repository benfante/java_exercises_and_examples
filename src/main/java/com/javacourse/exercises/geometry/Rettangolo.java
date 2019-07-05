package com.javacourse.exercises.geometry;

public class Rettangolo extends Figura {
	private double lato1, lato2;

	public Rettangolo(double lato1, double lato2) {
		this.lato1 = lato1;
		this.lato2 = lato2;
	}

	public double area() {
		return lato1 * lato2;
	}
}
