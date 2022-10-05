package com.javacourse.examples.patterns.singleton;

public class Singleton {
	private static final Singleton instance;

	static {
		instance = new Singleton();
	}
	
	private Singleton() {
	}

	public static Singleton getInstance() {
		return instance;
	}
}

class UseSingleton {
	public static void main(String[] args) {
		Singleton singleton = Singleton.getInstance();
		System.out.println(singleton);
	}
}