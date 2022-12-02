package org.elsys_bg.something;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) throws IOException {
        File f = new File("int.txt");
//        FileWriter fw = new FileWriter(f);
//        fw.write("" + Integer.MAX_VALUE);
//        fw.flush();
//        fw.close();
        Scanner sc = new Scanner(f);
        BigInteger i = sc.nextBigInteger();
        System.out.println(i);
    }
}
