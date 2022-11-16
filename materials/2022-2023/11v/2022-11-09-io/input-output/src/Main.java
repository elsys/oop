import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        System.out.printf("Hello %.2f\n", 1.23456);

//        File f = new File("test.txt");
        try {
//            FileOutputStream fos = new FileOutputStream(f);
            FileOutputStream fos = new FileOutputStream(args[0]);
            PrintStream ps = new PrintStream(fos);

            fos.write("fso.write".getBytes());
            fos.flush();

            ps.println("Hello");
            ps.println(123);

            fos.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

//        System.in.read
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        Scanner sc = new Scanner(System.in);
//        int a = sc.nextInt();
////        int b = sc.nextInt();
//        String c = sc.next();

        try {
            FileInputStream fis = new FileInputStream(args[0]);

            Scanner s = new Scanner(fis);
//            System.out.println(s.nextLine());
//            System.out.println(s.nextInt());
            while(s.hasNext()) {
                System.out.println(s.nextLine());
            }

            fis.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Scanner s2 = new Scanner("124134 ivan voina");
//        System.out.println(s2.nextBigInteger());
        System.out.println(s2.nextInt());
        System.out.println(s2.next());

        for (String s :
                args) {
            System.out.println(s);
        }

        int a = Integer.parseInt(args[1]);
    }
}
