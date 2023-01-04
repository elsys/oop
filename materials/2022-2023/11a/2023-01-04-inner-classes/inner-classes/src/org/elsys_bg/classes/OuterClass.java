package org.elsys_bg.classes;

public class OuterClass {
    private static int p;
    private int i;

    public void test() {
        InnerClass in = new InnerClass(5);
        in.i = 5;
    }

    public class InnerClass{
        private int t;
        private int i;

        public InnerClass(int t) {
            this.t = t;
            this.t = i;
        }

        public void test(int i) {
            InnerClass.this.i = 5;
            OuterClass.this.i = 5;
            this.i = p;
        }
    }

    public static class StaticInnerClass {
        int d;
        public void test() {
            d = p;
            OuterClass oc = new OuterClass();
            d = oc.i;
        }
    }
}
