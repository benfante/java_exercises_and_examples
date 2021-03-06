package com.javacourse.examples;

public class DefaultConstructorExample {
	private String anAttribute;
	private int h;
	private final int k;
	@SuppressWarnings("unused")
	private static final int Z;
	
	static {
		Z = 10;
	}
	
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
//		DefaultConstructorExample.z = 10;
		//DefaultConstructorExample instance = new DefaultConstructorExample();
		DefaultConstructorExample instance = new DefaultConstructorExample("a parameter");
		// instance.k = 54; // no, it's final
		System.out.println(instance);
	}

	public static void m() {
//		DefaultConstructorExample.z = 10;		
	}
	
	public void n(DefaultConstructorExample this) {
	}
	
	@Override
	public String toString() {
		return "DefaultConstructorExample [anAttribute=" + anAttribute + ", h=" + h + ", k=" + k + "]";
	}


}
