package org.elsys;

public class StringExamples {

    public static void main(String[] args) {
        String s1 = "string";
        String s2 = "string";
        if (s1 == s2) {
            System.out.println("s1 and s2 are ==");
        }
        String s3 = new String("string");
        if (s1 == s3) {
            System.out.println("s1 and s3 are ==");
        }
        if (s1.equals(s3)) {
            System.out.println("s1 and s3 are equal");
        }

        Integer i1 = 1;
        Integer i2 = 1;
        Integer i3 = new Integer(1);
        if (i1 == i2) {
            System.out.println("i1 and i2 are ==");
        }
        if (i1 == i3) {
            System.out.println("i1 and s3 are ==");
        }
        if (i1.equals(i3)) {
            System.out.println("i1 and i3 are equal");
        }
    }
}
