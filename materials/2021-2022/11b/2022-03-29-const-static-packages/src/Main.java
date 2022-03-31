public class Main {
//    private static final class Test1 {
//        public int test = 5;
//
//        public final void testMethod2() {
//
//        }
//    }

//    private static class Test2 extends Test1 {
//        public void testMethod2() {
//        }
//    }

//    private static void testMethod1(final int arg) {
//        arg = 10;
//    }


    public static void main(String[] args) {
        final int a = 5;
        a = 10;

        final Test1 b = new Test1();
        b.test = 10;
        b = new Test1();

        System.out.println(Test2.a);
        System.out.println(Math.PI);
    }
}

//Main.main(args);
