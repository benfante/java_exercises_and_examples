package com.javacourse.examples;

public class DefaultConstructorExample {
	private String anAttribute;
	private int h;
	private final int k;
	
	{
		h = 3;
	}
	
	// no more default constructor
	public DefaultConstructorExample(String anAttribute) {
		this(anAttribute, 23);
		this.h = 34;
	}

	public DefaultConstructorExample(String anAttribute, int k) {
		this.k = k;
		this.anAttribute = anAttribute;
	}
	
	public static void main(String[] args) {
		DefaultConstructorExample instance = new DefaultConstructorExample("pippo");
		// instance.k = 54; // no, it's final
		System.out.println(instance);
	}

	@Override
	public String toString() {
		return "DefaultConstructorExample [anAttribute=" + anAttribute + ", h=" + h + ", k=" + k + "]";
	}


}
