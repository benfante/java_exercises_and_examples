package com.javacourse.examples;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface QueryGenerator {
    String findAllPerson();
    String findAllUsers();
    String findAllEmployee();
}

class MyInvocationHandler implements InvocationHandler {

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String entity = method.getName().substring(7);
        return String.format("SELECT * from %s;", entity);
    }

}

public class ProxyExample {
    public static void main(String[] args) {
        InvocationHandler handler = new MyInvocationHandler();
        QueryGenerator proxy = (QueryGenerator) Proxy.newProxyInstance(
                QueryGenerator.class.getClassLoader(),
                new Class[] { QueryGenerator.class },
                handler);
        System.out.println(proxy.findAllPerson());
        System.out.println(proxy.findAllUsers());
        System.out.println(proxy.findAllEmployee());
    }
}
