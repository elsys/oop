package org.elsys_bg.Hello;

//void test() {
//
//        }

public class Main {
    /*
    public
    protected
    private
    default/package private
     */

    public int a;
    public int b;
    public int c = 10, d, e = 20, g;

    public static void main(String[] args) {
        System.out.println("Hello World");
        int q = 2;
        char c = 'a';
        double d = 2.5d;
        float f = 1.3f;
        boolean b = true; //false
        char r = 35;

        /*
        operatrs:
        >, <, <=, >=, !, &&, ||, ==, *, /, + , -, %, ?:, +=, -=,
         */
        for (int i = 0; i < 10; i++) {
            System.out.println("i:" + i);
        }

        String str = "asdasd\n" + "asdas" + "qwe";
        String str2 = """
                asasd "asdsad" asdsd
                asdasd
                asdsad
                """;

        System.out.println(str2);

        int[] arr = {1, 2, 3, 4};
        int[] arr2 = new int[20];
        arr2[1] = 120;

        var a = 10;

        for (var g : arr) {
            System.out.println(g);
        }

        if (a == 10) {

        } else if (false) {
        }

//        while (true) {
//
//        }

//        do {
//
//        } while(true);

        switch (q) { //can switch on int, char instance of
            case 10:
                break;
            case 20:
                break;
        }

        System.out.println(r);
    }

    public void test() {
        return;
    }
}
