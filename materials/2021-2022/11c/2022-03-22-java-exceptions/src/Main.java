public class Main {
    public static void test2() throws Exception {
        throw new Exception("demo");
//        throw new IllegalAccessException("demo 2");
    }

    public static void test1() throws Exception {
        try {
            test2();
        } catch(IllegalAccessException ex) {
            System.out.println("catch1 in test1");
        } catch(IndexOutOfBoundsException ex) {
            System.out.println("catch2 in test1");
        } finally {
            System.out.println("finally in test1");
        }
    }

    public static void main(String[] args) {
        System.out.println("before try");
        try {
            System.out.println("before test1");
            test1();
            System.out.println("after test1");
        } catch(Exception ex) {
            System.out.println("Inside catch");
            ex.printStackTrace();
            System.out.println("error is " + ex.getMessage());
        }
        System.out.println("after try");
    }
}
