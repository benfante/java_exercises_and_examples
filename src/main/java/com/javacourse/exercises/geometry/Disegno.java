package com.javacourse.exercises.geometry;

import java.util.ArrayList;
import java.util.List;

public class Disegno {
	List<Figura> foglio = new ArrayList<>();
	
	public void add(Figura f) {
		foglio.add(f);
	}
	
	public void print() {
		for (Descrivibile f : foglio) {
			System.out.println(f);
		}
	}
	
	public double calculateTotalArea() {
		double result = 0;
		for (Superficie superficie : foglio) {
			result += superficie.area();
		}
		return result;
	}
	
	
	public static void main(String[] args) {
		Disegno disegno = new Disegno();
		disegno.add(new Rettangolo(2, 3));
		disegno.add(new Quadrato(5));
		disegno.add(new Triangolo(4, 5));
		disegno.add(new Cerchio(6));
		disegno.print();
	}
}
