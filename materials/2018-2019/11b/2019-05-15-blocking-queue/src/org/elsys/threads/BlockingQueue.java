package org.elsys.threads;

import java.util.LinkedList;

public final class BlockingQueue<E> {

    private final int size;

    private final LinkedList<E> values = new LinkedList<>();

    public BlockingQueue(int size) {
        this.size = size;
    }

    public synchronized void push(E value) {
        while (values.size() >= size) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        values.add(value);
        notifyAll();
    }

    public synchronized E pop() {
        while (values.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        notifyAll();
        return values.pop();
    }
}
