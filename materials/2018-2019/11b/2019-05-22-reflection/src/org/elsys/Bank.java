package org.elsys;

import java.lang.reflect.*;
import java.util.Arrays;

public class Bank {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        final Bill b = new Bill(15);
        final Class<? extends Bill> bClass = b.getClass();

        System.out.println(bClass.getName());
        System.out.println(bClass.getSuperclass().getName());

        // Stream version
        Arrays.stream(bClass.getInterfaces())
                .map(Class::getName)
                .forEach(System.out::println);

        Arrays.stream(bClass.getDeclaredConstructors())
                .forEach(System.out::println);

        Arrays.stream(bClass.getDeclaredFields())
                .map(Field::getModifiers)
                .map(Modifier::toString)
                .forEach(System.out::println);


        /* Loop version

        for (Class<?> aClass : bClass.getInterfaces()) {
            String name = aClass.getName();
            System.out.println(name);
        }

        for (Constructor<?> constructor : bClass.getDeclaredConstructors()) {
            System.out.println(constructor);
        }

        for (Field field : bClass.getDeclaredFields()) {
            Integer modifiers = field.getModifiers();
            String s = Modifier.toString(modifiers);
            System.out.println(s);
        }

        */

        Method getValue = bClass.getDeclaredMethod("getValue");

        System.out.println(getValue.invoke(b));
        System.out.println(serializer(b));

    }

    private static String serializer(final Object obj) throws IllegalAccessException {
        final Class<?> objClass = obj.getClass();
        StringBuilder result = new StringBuilder();

        // Opening signature
        result.append(objClass.getName())
                .append("/\n");

        // Contents (fields)
        for (Field field : objClass.getDeclaredFields()) {
            field.setAccessible(true);  // Makes private fields visible

            result.append(field.getName())
                    .append(" = ")
                    .append(field.get(obj))
                    .append("\n");
        }


        // Closing signature
        result.append("/")
                .append(objClass.getName());

        return result.toString();
    }
}
