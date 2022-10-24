package org.elsys_bg.java.intro;

public class Main {
    //default - package private
    //acts as public for all classes in the
    // same package and private for all other
    public int a;
    protected int b;
    int c;
    private int d;
    public static void main(String[] args) {
        String str = "Hello";
        String str2 = "Hello";
        Object o;
        Main main = new Main();
        String str3 = new String("Hello");
        //== compares memory address
        if(str == str2) {
            System.out.println("str and str2 are equal");
        }

        if(str == str3) {
            System.out.println("str and str3 are equal");
        }

        if(str.equals(str3)) {
            System.out.println("str and str3 are equal");
        }

//        int i = 7;
//        char c = 'c';
//        long l = 2l;
//        float f = 2.3f;
//        double d = 3.4d;
//        double z = (double) 3 / 2;
//        System.out.println(z);
//        boolean b = true;
//
//        Integer io = 2;
//        io = i;
//        Double dd;
//        Long ll;
//        Character cc;
//        Float ff;
//        Boolean bb;
////        if(b) {
////            //something
////        } else if (bb) {
////            //something
////        } else {
////            //something
////        }
//
//        int arr[] = new int[1];
//        int arr2[] = {2,3,4};
//
//        for(int j = 0; j < arr.length; j++) {
//            int arrNew[] = new int[20];
//            if(b) {
//                break;
//            } else {
//                continue;
//            }
//        }
//
//        for(int j : arr2) {
//            System.out.println(j);
////            return;
//        }
//
////        do {
////
////        } while (true);
//
////        while (true) {
////            if(b) {
////                break;
////            }
////        }
//        //int, long, char, ENUM, String
//        switch (i) {
//            case 2:
//                System.out.println(5);
//                break;
//            case 3:
//                System.out.println(6);
//            case 4:
//                System.out.println(7);
//                break;
//            default:
//                System.out.println(9);
//        }
//
//        switch (i){
//            case 2, 4, 5 -> System.out.println(2);
//            case 3 -> System.out.println(4);
//            default -> System.out.println(10);
//        }

    }

    public int getValue() {
        return 1;
    }
}