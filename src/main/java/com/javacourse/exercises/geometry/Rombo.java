package com.javacourse.exercises.geometry;

public class Rombo extends Figura {
	private double diagonale1, diagonale2;
	
	public Rombo(double diagonale1, double diagonale2) {
		this.diagonale1 = diagonale1;
		this.diagonale2 = diagonale2;
	}

	@Override
	public double area() {
		return diagonale1 * diagonale2 /2;
	}

}
