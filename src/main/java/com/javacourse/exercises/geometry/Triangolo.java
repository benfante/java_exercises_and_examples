package com.javacourse.exercises.geometry;

public class Triangolo extends Figura {
	private double base, altezza;

	public Triangolo(double base, double altezza) {
		this.base = base;
		this.altezza = altezza;
	}

	public double area() {
		return base * altezza / 2;
	}
}
