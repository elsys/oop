import java.io.*;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    public static class MyException extends Exception {
        public MyException(String arg) {
            super(arg);
        }
    };

    static void foo(Object arg) throws FileNotFoundException, MyException {
//        try {
            if (arg == null)
                throw new MyException("Invalid argument");

            throw new FileNotFoundException();
            // do some work
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        }
    }

    static void bar() throws MyException {
        System.out.println("Hello world!");

        try {
            foo(null);
        } catch (FileNotFoundException e) {
//            System.out.println(e.getStackTrace());
            e.printStackTrace();
        } catch (MyException e) {
//            System.out.println(e.getStackTrace());
            e.printStackTrace();
//            return;
            throw e;
        } finally {
            System.out.println("In main finally");
        }

        System.out.println("AFter catch");
    }

    static void baz() {
//        InputStream is = new BufferedInputStream(System.in);
//        BufferedInputStream is = new BufferedInputStream(System.in);
//        DataInputStream dis = new DataInputStream(is);

//        try {
//            int c;
//            while((c = is.read()) != -1) {
//                System.out.println(c);
//            }
//        } catch (IOException e) {
//            System.out.printf("Failed to read");
//            System.out.printf(e.getMessage());
//        }

//        try {
//            int a = dis.readInt();
//            String b = dis.readLine();
//            System.out.println(a);
//            System.out.println(b);
//        } catch (IOException e) {
//            System.out.printf("Failed to read");
//            System.out.printf(e.getMessage());
//        }
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        );
        try {
            System.out.println(br.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Scanner sc = new Scanner(
                new BufferedInputStream(System.in)
        );
        while(sc.hasNextLine()) {
            sc.nextLine();
        }

        try {
            Scanner fsc = new Scanner(
//                    new FileInputStream("./in.txt")
//                    new BufferedInputStream(
//                            new FileInputStream("./in.txt")
//                    )
//                    "./in.txt"
                    Paths.get("./in.txt")
            );

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws MyException {
//        bar();
        baz();
    }
}