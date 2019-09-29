package org.elsys;

public class OuterClass {

    public class InnerClass {

    }

    public static class InnerStaticClass {

    }

    public static void main(String args[]) {
        OuterClass outer = new OuterClass();
        InnerClass ic = outer.new InnerClass();
        InnerStaticClass isc = new InnerStaticClass();
    }
}
