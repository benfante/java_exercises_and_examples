package com.javacourse.exercises.geometry;

import java.util.Objects;

public class Rettangolo extends Figura {
	private double lato1, lato2;

	public Rettangolo(double lato1, double lato2) {
		this.lato1 = lato1;
		this.lato2 = lato2;
	}

	public double area() {
		return lato1 * lato2;
	}

	private boolean compareDoubles(double d1, double d2) {
		double epsilon = 0.00001;
		return (Math.abs(d1-d2) < epsilon);
	}

	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof Rettangolo)) {
			return false;
		}
		Rettangolo rettangolo = (Rettangolo) o;
		// return (lato1 == rettangolo.lato1 && lato2 == rettangolo.lato2)
		// 		|| (lato1 == rettangolo.lato2 && lato2 == rettangolo.lato1);
		return (compareDoubles(lato1, rettangolo.lato1) && compareDoubles(lato2, rettangolo.lato2))
				|| (compareDoubles(lato1, rettangolo.lato2) && compareDoubles(lato2, rettangolo.lato1));
	}

	@Override
	public int hashCode() {
		return Objects.hash(lato1 + lato2);
		//return 31;
	}
}
