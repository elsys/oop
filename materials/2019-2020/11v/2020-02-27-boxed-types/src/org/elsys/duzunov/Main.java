package org.elsys.duzunov;

import java.util.ArrayList;
import java.util.List;

public class Main {
    // Операциите за работа с числа като '%' и '+=' работят с примитивни числови
    // типове. Когато ги използваме с обекти от boxed еквивалентите им, се
    // случва автоматично разопаковане (unboxing) преди да бъдат изпълнени
    // съответните операции.
    public static int sumEvens(List<Integer> integers) {
        int sum = 0;
        for (var integer : integers) {
            if (integer % 2 == 0) { // if (integer.intValue() % 2 == 0) {
                sum += integer; // sum += integer.intValue();
            }
        }
        return sum;
    }

    public static int absoluteValue(int i) {
        return i < 0 ? -i : i;
    }

    public static void main(String[] args) {
        int x = 42;
        System.out.println(x);
        // Пример за autoboxing при присвояване
        Integer boxedX = x; // <=> Integer boxedX = Integer.valueOf(x);
        System.out.println(boxedX);

        // Пример за unboxing при присвояване
        int y = boxedX; // <=> int y = boxedX.intValue();
        System.out.println(y);

        var integers = new ArrayList<Integer>();
        // Примери за autoboxing при извикване на метод
        integers.add(1); // <=> integers.add(Integer.valueOf(1));
        integers.add(2); // <=> integers.add(Integer.valueOf(2));
        integers.add(42); // <=> integers.add(Integer.valueOf(42));
        int sum = sumEvens(integers);
        System.out.println(sum);

        // Пример за unboxing при извикване на метод
        int absoluteValueOfX = absoluteValue(boxedX);
        // int absoluteValueOfX = absoluteValue(boxedX.intValue());
        System.out.println(absoluteValueOfX);
    }
}
