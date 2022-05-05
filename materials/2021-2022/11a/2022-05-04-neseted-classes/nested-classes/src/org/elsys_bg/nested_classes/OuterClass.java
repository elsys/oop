package org.elsys_bg.nested_classes;

//WhitespaceReplaceUtils
public class OuterClass {
    private static String charToReplace = " ";
    private static String charToReplaceWith = "a";
    private int value = 2;
    private static int staticValue = 3;

    public static String replace(String value) {
        return value.replace(charToReplace, charToReplaceWith);
    }

    //can be public, private, protected and package private
    public class NestedClass {
        private static int testValue = 2;
        private int testValue2 = 3;
        public void printValue() {
            System.out.println(value);
        }
    }

    public void test() {
        int testValue = NestedClass.testValue;
        NestedClass nc = new NestedClass();
        int testValue2 = nc.testValue2;
    }

    public static class StaticNestedClass {
        public static void printStaticValue() {
            System.out.println(staticValue);
        }

        public void printValue(OuterClass oc) {
            System.out.println(oc.value);
        }
    }
}
