import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.IndicativeSentencesGeneration;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ParallelListTest {

    List<Integer> l;
    @BeforeEach
    void setup() {
        l = new ParallelList<>();
        l.add(5);
    }

    @AfterEach
    void tearDown() {
        Thread[] allThreads = new Thread[Thread.activeCount()];
        Thread.enumerate(allThreads);
        System.out.println("TEARDOWN 1");
        for(Thread t : allThreads) {
            System.out.println(t.getName());
            if(t.getName().length() > 6 &&
                    t.getName().substring(0, 6).equals("pool-1")) {
                while(t.isAlive()) {
                    t.interrupt();
                }
            }
        }
    }

    @AfterEach
    void tearDown2() {
        System.out.println("TEARDOWN 2");
        Thread[] allThreads = new Thread[Thread.activeCount()];
        Thread.enumerate(allThreads);

        for(Thread t : allThreads) {
            System.out.println(t.getName());
        }
    }

    @Test
    void forEach() {
        List<Integer> results = new LinkedList<>();

        final int originalThreadCount = Thread.activeCount();

        l.forEach((e) -> results.add(e * e));

//        try {
//            l.wait()
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        l.notify();

        try {
            while(Thread.activeCount() != originalThreadCount) {
                Thread.sleep(1);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        assertEquals(results.size(), 1);
        assertEquals(results.get(0), 25);
    }

    @Test
    void forEachInfinite() {
        List<Integer> results = new LinkedList<>();

        final int originalThreadCount = Thread.activeCount();

        l.forEach((e) -> {
            try {
                Thread.sleep(Long.MAX_VALUE);
                results.add(e * e);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
        });

        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        assertEquals(results.size(), 0);
    }
}