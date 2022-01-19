package com.javacourse.examples;

interface MyInterface {
    int aMethod();
}

public class AnonynousClassExample {
    public static void main(String[] args) {

        MyInterface o1 = new MyInterface() {
            @Override
            public int aMethod() {
                return 50;
            }

            @Override
            public String toString() {
                return Integer.toString(aMethod());
            }
        };

        System.out.println(o1);

        // Implementing a functional interface using lambdas 
        MyInterface o2 = () -> 23;
        System.out.println(o2.aMethod());
    }
}
