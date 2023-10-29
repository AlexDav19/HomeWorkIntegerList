package org.example;

import java.lang.reflect.*;


public class ReflectionExample {
    public static void main(String[] args) {
        IntegerListImpl integerList = new IntegerListImpl(10);
        containsSort1(integerList);
    }

    public static void containsSort1(IntegerListImpl integerList) {
        try {
            Method method = integerList.getClass().getDeclaredMethod("containsSort");
            method.setAccessible(true);
            method.invoke(integerList);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
