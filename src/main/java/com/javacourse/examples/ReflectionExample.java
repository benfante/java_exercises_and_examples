package com.javacourse.examples;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

@SuppressWarnings("rawtypes")
public class ReflectionExample {
    public static void main(String[] args) throws ClassNotFoundException {
        Class c = (args.length > 0) ? Class.forName(args[0]) : String.class;
        System.out.println(c.getName());
        for (Constructor constructor : c.getConstructors()) {
            System.out.print("  ");
            System.out.println(constructor);
        }
        System.out.println("  --------------------");
        for (Field field : c.getDeclaredFields()) {
            System.out.print("  ");
            System.out.println(field);
        }
        System.out.println("  --------------------");
        for (Method method : c.getMethods()) {
            System.out.print("  ");
            System.out.println(method);
        }
    }
}