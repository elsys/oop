package org.elsys.duzunov;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class Main {
    public static void main(String[] args) {
        int i = 0;
        // read-modify-write race condition
        ++i; // еквивалентно на i = i + 1,
        // което всъщност се състои от три операции:
        // - прочитане на i
        // - изчисляване на нова стойност за i (i + 1)
        // - записване на новата стойност за i (операцията за присвояване)

        // Атомарни операции
        // Всички имплементации имат методи get() и set() за достъп до
        // съхраняваната променлива.
        AtomicInteger atomicInt = new AtomicInteger();
        atomicInt.set(2020);
        System.out.println(atomicInt.get()); // 2020

        // thread-safe вариант на ++i (i = i + 1)
        System.out.println(atomicInt.incrementAndGet()); // 2021

        // thread-safe вариант на i += x (i = i + x)
        System.out.println(atomicInt.addAndGet(5)); // 2026

        AtomicReference<String> atomicRef = new AtomicReference<>();
        // atomicRef не е null, но стойността, която съдържа (wrap-ва), е null

        // thread-safe вариант на if (ref == expectedValue) { ref = newValue; }
        // Важно: сравняваме референции затова използваме `==`, а не equals
        atomicRef.compareAndSet(null, "Happy new year!");
        System.out.println(atomicRef); // Happy new year!

        // Нишки
        // Създаване
        // Първи начин: наследяване на java.lang.Thread класа
        class CustomThread extends Thread {
            @Override
            public void run() {
                System.out.println("Hello asynchronous world! (vol. 1)");
            }
        }
        Thread thread1 = new CustomThread();

        // Втори начин: имплементиране на java.lang.Runnable интерфейса
        class CustomRunnable implements Runnable {
            @Override
            public void run() {
                System.out.println("Hello asynchronous world! (vol. 2)");
            }
        }
        CustomRunnable runnable = new CustomRunnable();
        Thread thread2 = new Thread(runnable);

        // Стартиране (start изпълнява вътрешно run метода)
        thread1.start();
        thread2.start();

        runnable.run(); // просто изпълняваме run метода в текущата нишка (main)
    }

    private static Object foo(Object ref) {
        // check-then-act race condition
        if (ref == null) {
            ref = new Object();
        }
        return ref;
    }
}
