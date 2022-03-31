package org.elsys.oop;

public class Main {
    private static class Test {
        public int test = 5;
    }

    private static void testMethod1(final int arg) {
        arg = 10;
    }

    private final class Test2 {
        public int attr1 = 5;

        public final int testMethod2() {
            attr1 = 10;
            return attr1;
        }
    }

    private class Test3 extends Test2 {
        public int testMethod2() {
            attr1 = 10;
            return attr1;
        }
    }

    public static void main(String[] args) {
        final int a = 5;
       // a = 10;
        final Test b = new Test();
        //b = new Test();
        b.test = 10;

        final Integer c = new Integer(5);
        //c = 10;

        int d = (new Main()).testMethod2();
        d = 15;

        testMethod1(15);
    }
}


