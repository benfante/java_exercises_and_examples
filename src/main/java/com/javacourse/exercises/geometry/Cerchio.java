package com.javacourse.exercises.geometry;

public class Cerchio extends Figura {
	private double raggio;

	public Cerchio(double raggio) {
		this.raggio = raggio;
	}

	@Override
	public double area() {
		return Math.PI * raggio * raggio;
	}
}
