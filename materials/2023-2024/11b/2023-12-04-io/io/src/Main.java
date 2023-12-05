import java.io.*;
import java.net.Inet4Address;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static class Foo<T extends Number & Comparable> {
        private T myVar;

//        public void fooFoo() {
//            myVar.
//        }

        public void setMyVar(T myVar) {
            this.myVar = myVar;
        }

        public T getMyVar() {
            return myVar;
        }
    }

    public static void main(String[] args) {
//        Foo<Integer> myObj = new Foo<>();

//        List<Integer> myList = new LinkedList<>();
//        bar(myList);


        System.out.println("Hello");
//        System.in.
        InputStream sin = System.in;
        BufferedInputStream bis = new BufferedInputStream(sin);
//        bis.read();
//        sin.read ...
        InputStreamReader isr = new InputStreamReader(sin);
//        isr.read ...
        BufferedReader br = new BufferedReader(isr);
        try {
            br.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Scanner sc = new Scanner(sin);
        sc.nextInt();
        sc.next();

        try {
            FileInputStream fis = new FileInputStream("../data.txt");
            // ...
//            fis.read ...
            Scanner sc2 = new Scanner(fis);
            sc2.nextInt();
            sc2.next();

            fis.close();

            File f = new File("../data.txt");
            InputStream is = new FileInputStream(f);
//            f.length();
            is.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void bar(List<? super Integer> arg) {
        for (Object v : arg) {
            System.out.println(v);
        }
    }
}
