package org.elsys.duzunov;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("a1");
        strings.add("mtel");
        strings.add("telenor");
        strings.add(2, "vivacom");

        // Обхождане на списъци
        // Първи начин: стандартно обхождане с for цикъл по дължината на списъка
        for (int i = 0; i < strings.size(); ++i) {
            System.out.println(strings.get(i));
        }

        // Втори начин: чрез for цикъл с итератор
        for (Iterator<String> stringsIterator = strings.iterator();
             stringsIterator.hasNext();) {
            System.out.println(stringsIterator.next());
        }

        // Трети начин: чрез while цикъл с итератор - като горното, но по-четимо
        Iterator<String> stringsIterator = strings.iterator();
        while (stringsIterator.hasNext()) {
            System.out.println(stringsIterator.next());
        }

        // Четвърти начин: с добре познатата ни "for-each" конструкция
        for (String string : strings) {
            System.out.println(string);
        }

        // Тук използваме wrapper типа Integer вместо примитивния тип int, тъй
        // като Java не позволява да подаваме примитивни типове като типови
        // аргументи
        LinkedList<Integer> ints = new LinkedList<>();
        int x = 42;
        ints.add(x);
        ints.add(21);
        ints.add(33);

        // Имаме и специален итератор за списъци - ListIterator<T>, който ни
        // дава повече възможности за обхождане и модифициране на списъка (можем
        // да обхождаме и в двете посоки, можем да вмъкваме и елементи в
        // списъка)
        ListIterator<Integer> intsIterator = ints.listIterator();

        // Модифицирането на списъка чрез методи на списъка, след като сме взели
        // итератор към елементите на списъка, води то хвърлянето на
        // ConcurrentModificationException, за да се предотврати неочаквано
        // поведение при работата със списъка
        // ints.add(32); // тази модификация ще предизвика горното изключение
        // при следващото използване на итератора

        // Добавяме 1 след всеки елемент на списъка
        while (intsIterator.hasNext()) {
            System.out.println(intsIterator.next());
            intsIterator.add(1);
        }

        // Обхождаме списъка от края към началото му
        while (intsIterator.hasPrevious()) {
            System.out.println(intsIterator.previous());
        }

        Collections.sort(strings);
        for (String string : strings) {
            System.out.println(string);
        }

        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("Yoan", 15, 11));
        students.add(new Student("Ivan", 13, 11));
        students.add(new Student("Petar", 10, 11));

        Collections.sort(students);
        for (Student student : students) {
            System.out.println(student.getName());
        }
    }
}
