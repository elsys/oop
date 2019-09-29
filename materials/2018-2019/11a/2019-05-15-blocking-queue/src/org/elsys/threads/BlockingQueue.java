package org.elsys.threads;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class BlockingQueue<E> {

    private final int max;

    private final LinkedList<E> values;

    public BlockingQueue(int max) {
        values = new LinkedList<E>();
        this.max = max;
    }

    public synchronized void push(E value) {
        while (values.size() >= max) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        values.push(value);
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
