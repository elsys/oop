import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

//        int a = sc.nextInt();
//        System.out.println(a);
//
//        float b = sc.nextFloat();
//        System.out.println(b);
//
//        String c = sc.nextLine();
//        System.out.println(c);


       // for(int i = 0; i < 1000000; i++) System.out.println(i);

       // a = sc.nextInt();

        //sc = new Scanner("4 5.6 \nasdasd\n7");
        try {
            FileInputStream fs = new FileInputStream("./some/file.txt");
            fs.skip(10);
            sc = new Scanner(new FileInputStream("./some/file.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
