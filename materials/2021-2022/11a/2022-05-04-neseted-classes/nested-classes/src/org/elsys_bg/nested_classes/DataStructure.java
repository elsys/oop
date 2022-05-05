package org.elsys_bg.nested_classes;

import javax.xml.crypto.Data;
import java.util.Iterator;

public class DataStructure {
    private static final int SIZE = 15;
    private int array[] = new int[SIZE];

    public DataStructure() {
        for(int i = 0; i < SIZE; i++) {
            array[i] = i;
        }
    }

    public void  printEven() {
        EvenIterator iterator = new EvenIterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    interface DataStructureIterator extends Iterator<Integer>{};

    private class EvenIterator implements DataStructureIterator {
        private int nextIndex = 0;
        @Override
        public boolean hasNext() {
            return nextIndex < SIZE;
        }

        @Override
        public Integer next() {
            Integer value = Integer.valueOf(array[nextIndex]);

            nextIndex+= 2;
            return value;
        }
    }
}
