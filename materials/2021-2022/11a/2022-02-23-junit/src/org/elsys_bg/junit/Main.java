package org.elsys_bg.junit;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//        double result = Math.pow(2, 3);
//        System.out.println(result);
//        String s = "asd";
//        String s2 = "asd";
//        String s3 = new String("asd");
//        System.out.println(s == s3);
//        System.out.println(s.equals(s3));
//        String s4 = "as" + "d";
//        System.out.println(s == s4);
//        System.out.println(s == s3);
//        String s5 = s.replace('a', 'b');
//        System.out.println("s:" + s);
//        System.out.println("s5:" + s5);
//        String s6 = "asdasd" + "asdasd" + "\n" + "zxc" +
//                "zxc" +
//                "zxc";
//        String s7 = """
//                This is
//                new way
//                of defining strings
//                !
//                """;
//        String s8 = "This is \n new way\n" +
//                "of defining strings\n" +
//                "!";
//        System.out.println(s7);
//        System.out.println(s8);

        /*
        int, char, double, float, boolean
        Integer, Char, Double, Float, Boolean
        default value is null
         */
//        Integer i = new Integer(2);
//        Integer i2 = 4;
//        int i1 = i + 5;
//        List<Integer> l = new ArrayList();
//        int i3 = Integer.parseInt("5");
//        System.out.println(i3);
//
//        String s = "" + (5 + 6 + 7);
//        System.out.println(s);

        //default telimiter is whitespace
        Scanner sc = new Scanner(System.in);//new Scanner(new File("filePath"))    new Scanner(new String("..."))
        sc.useDelimiter("1");
        while (sc.hasNext()) {
            String i = sc.next();
            System.out.println(i);
        }
        sc.close();
    }

    public int sum(int a, int b) {
        return a + b;
    }

    int mul(int a, int b) {
        return a * b;
    }
}
