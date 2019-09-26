package com.javacourse.exercises.geometry;

public class Quadrato extends Figura {
	private double lato;

	public Quadrato(double lato) {
		this.lato = lato;
	}

	public double area() {
		return lato * lato;
	}
	
	@Override
	public String descriviti() {
		return super.descriviti()+" vero";
	}
}
