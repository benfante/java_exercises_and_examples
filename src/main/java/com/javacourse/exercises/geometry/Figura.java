package com.javacourse.exercises.geometry;

import java.util.Objects;

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


	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof Figura)) {
			return false;
		}
		Figura figura = (Figura) o;
		return this.area() == figura.area();
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(this.area());
	}
	
}