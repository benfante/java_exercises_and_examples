package com.javacourse.exercises.geometry;

public abstract class Figura {
	public abstract double area();

	public String toString() {
		return "L'area della figura " +
					descriviti() +
					" è " + area();
	}

	protected String descriviti() {
		return this.getClass().getSimpleName();
	}
}