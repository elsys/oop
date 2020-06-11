package org.elsys.duzunov;

public class ReentrantLockDemo {
    public void method1() {
        synchronized (this) {
            // thread 1 - owns this lock
            // изпълняващата нишка вече притежава lock-а
            // следователно може да извика method2()
            method2();
        }
    }

    public synchronized void method2() {
    }
}
