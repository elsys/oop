import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String str1 = "str1";
        String str2 = "str1";
        String str3 = new String("str1");
        //str3.
        String str4 = str1 + str2 + str3;
        StringBuilder str5 = new StringBuilder();
        for(int i = 0; i < 10; i++) {
            str5.append(i);
            str5.append(" ");
        }
        String str6 = str5.toString();

        System.out.println(str4);
        System.out.println(str5);
        System.out.println(str6);


        int a = 5;
        Integer b = 5;
        //  int => Integer
        // float => Float
        // double => Double
        // byte => Byte
        // long => Long
        // short => Short
        // char => Character
        // boolean => Boolean

        //int c = Integer.getInteger("asd");
        //System.out.println(c);

        //InputStreamReader isr = new InputStreamReader(System.in);

        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        );

        try {
            FileInputStream fis = new FileInputStream("asd.txt");
            Scanner sc = new Scanner(fis);
            sc.nextInt();
            sc.nextLine();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }




    }
}
