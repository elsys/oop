public class Main {
    private static void test2() throws IndexOutOfBoundsException {
        throw new Exception("demo");
//        throw new IndexOutOfBoundsException("demo 2");
    }

    private static void test1() {
        try {
            test2();
        } catch(IndexOutOfBoundsException ex) {
            System.out.println("got IndexOutOfBoundsException");
        } finally {
            System.out.println("test1 finally");
        }
//        test2();
    }

    public static void main(String[] args) {
        System.out.println("Before try");
        try {
            System.out.println("Before throw");
            test1();
        } catch(Exception ex) {
//            ex.printStackTrace();
            System.out.println(ex.getStackTrace());
        }
        System.out.println("After try");
    }
}
