package com.javacourse.examples;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface QueryGenerator {
    String findAllPerson();
    String findAllUsers();
    String findAllEmployee();
    String searchPersonById(long id);
}

class MyInvocationHandler implements InvocationHandler {

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        String name = method.getName();
        if (name.startsWith("findAll")) {
            String entity = name.substring(7);
            return String.format("SELECT * from %s;", entity);
        } else if (name.startsWith("search")) {
            int byIndex = name.indexOf("By");
            return String.format("SELECT * from %s WHERE %s = %s;", name.substring(6, byIndex), name.substring(byIndex + 2), args[0]);
        }
        return "Bohhh...";
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
        System.out.println(proxy.searchPersonById(5));
    }
}
