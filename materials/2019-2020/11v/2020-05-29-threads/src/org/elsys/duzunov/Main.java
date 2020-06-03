package org.elsys.duzunov;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class Main {
    public static void main(String[] args) throws InterruptedException {
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

        // Имена и групи
        thread1.setName("Cool thread #1");
        thread2.setName("Cool thread #2");

        // Конструктор, който приема група и име
        ThreadGroup coolThreads = new ThreadGroup("Cool thread group");
        Thread coolThread1 = new Thread(coolThreads, "Cool thread #1");

        // Конструктор, който приема група, Runnable инстанция и име
        Thread coolThread2 = new Thread(
                coolThreads,
                new CustomRunnable(),
                "Cool thread #2"
        );

        // „Спане“ – нишката „заспива“ и не получава процесорно време
        // за определен интервал време
        Thread.sleep(1000);
        coolThread2.start();

        // Референция към текущата нишка
        Thread currentThread = Thread.currentThread();
        System.out.println(currentThread.getName());

        Thread fooThread = new Thread(
                () -> System.out.println(Thread.currentThread().getName()),
                "Foo thread"
        );
        fooThread.start();

        Thread greetingThread = new Thread(() -> {
            System.out.println("Hello!");

            // Stack trace-ът на нишката
            StackTraceElement[] stackTrace =
                    Thread.currentThread().getStackTrace();
            System.out.println(Arrays.toString(stackTrace));
        });
        greetingThread.start();

        // Приоритет на нишки
        // Подсказка към диспечера на нишки, каква част от процесорното
        // време да получи дадена нишка. Скалата е от 1 до 10.
        // По-малко число означава по-висок приоритет.
        // Приоритетът по подразбиране е 5.
        currentThread.setPriority(2);

        // Текущата нишка се отказва от своето процесорно време в полза
        // на друга, чийто приоритет е минимум колкото този на текущата.
        // Използва се главно за по-добро оползотворяване на ресурсите и
        // дебъгване на race conditions.
        Thread.yield();

        // Важно:
        // Добре написано приложение не трябва да разчита на
        // приоритетите на нишки или на yield за своята коректност

        Thread firstThread = new Thread(() -> System.out.println("First"));
        Thread secondThread = new Thread(() -> System.out.println("Second"));
        Thread thirdThread = new Thread(() -> {
            try {
                Thread.sleep(6000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Third");
        });
        Thread fourthThread = new Thread(() -> System.out.println("Fourth"));

        firstThread.start();

        // Присъединяване към друга нишка
        // Дадена нишка може да паузира изпълнението си,
        // докато друга нишка приключи, чрез метода join().
        // Извикващата нишка блокира, докато нишката, на която е извикала
        // join, приключи.
        firstThread.join();
        secondThread.start();
        secondThread.join();
        thirdThread.start();

        // Ако нишката приключи или зададеното време изтече, извикващата
        // нишка ще продължи изпълнението си
        thirdThread.join(3000);
        fourthThread.start();

        // Можем да проверим дали дадена нишка не е приключила изпълнението си
        if (thirdThread.isAlive()) {
            System.out.println("Third thread is still alive");
        } else {
            System.out.println("Third thread has died");
        }

        // Daemon нишки:
        // - изпълняват задачи, които не са жизненоважни за програмата
        // - JVM ще прекрати работата на нишките от този тип, ако няма поне една
        // работеща стандартна нишка (non-daemon)
        // - нишките наследяват режима на работа от тази, която ги е създала,
        // или го задават експлицитно
        // - всяка JVM програма работи, докато има поне една работеща
        // стандартна нишка (non-daemon)
        // - стандартните нишки (non-daemon нишките) изпълняват задачи, които са
        // свързани с основната идея на програмата
        Thread daemonThread = new Thread(
                () -> System.out.println("I'm a daemon thread!")
        );
        daemonThread.setDaemon(true);

        // Състояние
        System.out.println(daemonThread.getState());
        daemonThread.start();
        System.out.println(daemonThread.getState());
        daemonThread.join();
        System.out.println(daemonThread.getState());
    }

    private static Object foo(Object ref) {
        // check-then-act race condition
        if (ref == null) {
            ref = new Object();
        }
        return ref;
    }
}
