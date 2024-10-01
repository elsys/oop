import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*System.out.println(args.length);

        for (String arg : args) {
            System.out.println(arg);
        }

        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        try {
            String line = br.readLine();
            System.out.println(line);
            int num = Integer.parseInt(line);
            System.out.println(num);
        } catch (IOException e) {
            e.printStackTrace();
        }*/

//        Scanner in = new Scanner(System.in);

//        System.out.println(in.nextLine());
//        int num = in.nextInt();
//        System.out.println(num);

//        String line = System.console().readLine();
//        System.out.println(line);

//        String str1 = "Hello";
//        String str2 = "Hello";
//        String str3 = str1.concat(str2);

        StringBuilder sb  = new StringBuilder();
        sb.append("Hello").append(" ").append("World");
        System.out.println(sb);
    }
}
