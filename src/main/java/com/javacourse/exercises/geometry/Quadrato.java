package com.javacourse.exercises.geometry;

import java.util.Objects;

public class Quadrato extends Figura {
	private double lato;

	public Quadrato(double lato) {
		this.lato = lato;
	}

	@Override
	public double area() {
		return lato * lato;
	}
	
	@Override
	public String descriviti() {
		return super.descriviti()+" vero";
	}


	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof Quadrato)) {
			return false;
		}
		Quadrato quadrato = (Quadrato) o;
		return lato == quadrato.lato;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(lato);
	}

}
