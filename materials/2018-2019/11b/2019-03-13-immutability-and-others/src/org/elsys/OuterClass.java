package org.elsys;

public class OuterClass {

    private String value;

    public class InnerClass {

        public void changeValue(String v) {
            value = v;
        }
    }

    public static class InnerStaticClass {

    }

    public static void main(String args[]) {
        OuterClass oc = new OuterClass();
        InnerClass ic = oc.new InnerClass();
        InnerStaticClass isc = new InnerStaticClass();

        class InnerFunctionClass {

        }

        InnerFunctionClass ifc = new InnerFunctionClass();
    }
}
