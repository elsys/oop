package org.elsys_bg.exceptions;

import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ConnectException;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        try {
            writeToFile("asdsa");
        } catch (Exception ex) {
            handleException(ex);
        }

    }

    private static void handleException(Exception ex) {
        if(ex instanceof IllegalArgumentException) {
            System.out.println();
        } else if(ex instanceof NullPointerException) {

        }
    }

    private static void writeToFile(String text) throws IOException, ConnectException, ArrayIndexOutOfBoundsException {
        try {
            if (text.trim().length() < 10) {
                throw new IllegalArgumentException("Wrong length");
            }
        } catch (IllegalArgumentException ex) {

        }

        FileWriter fw = getFileWriter();
        try {
            fw.write(text);
        } catch (IOException e) {
            System.out.println("Oh nO");
            throw new RuntimeException();
        } finally {
            try {
                fw.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        try (FileWriter writer = new FileWriter("asd")) {
            writer.write("asd");
        } catch (IOException ex) {

        }
    }

    private static FileWriter getFileWriter() {
        FileWriter fw = null;
        try {
            fw = new FileWriter("test.txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return fw;
    }
}