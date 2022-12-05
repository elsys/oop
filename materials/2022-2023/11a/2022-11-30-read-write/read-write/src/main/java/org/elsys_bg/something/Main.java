package org.elsys_bg.something;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Hello world!");

        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("");
//        String line = sc.nextLine();
//        String next = sc.next();
//        System.out.println(next);
//        int i = sc.nextInt();
//        System.out.println(i);

//        System.out.println(line);
        sc.close();

        try {
            File file = new File("./src/main/java/");
            System.getProperty("");
            String path = "asd" + File.separator + "asd";
            FileWriter writer = new FileWriter(file, true);
            writer.write("asdasdsa\n");
            writer.flush();
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        File f = new File("");
        Scanner sc2 = new Scanner(f);



//        try {
//            file.createNewFile();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
    }
}