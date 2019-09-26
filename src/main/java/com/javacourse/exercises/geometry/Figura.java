package com.javacourse.exercises.geometry;

public abstract class Figura implements Superficie, Descrivibile {

	@Override
	public String toString() {
		return "L'area della figura " +
					descriviti() +
					" è " + area();
	}

	@Override
	public String descriviti() {
		return this.getClass().getSimpleName();
	}

}