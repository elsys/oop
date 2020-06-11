package org.elsys.duzunov;

public class MultipleLocksDemo {
    private final Object lock1 = new Object();
    private final Object lock2 = new Object();
    private final Object lock3 = new Object();

    // Държането на няколко ключалки е лоша практика и
    // при възможност трябва да се избягва
    public void multipleLocks() {
        synchronized (lock1) {
            // нишката притежава lock1
            synchronized (lock2) {
                // нишката притежава lock1 & lock2
                synchronized (lock3) {
                    // нишката притежава lock1, lock2 & lock3
                }
                // нишката притежава lock1 & lock2
            }
            // нишката притежава lock1
        }
    }
}
