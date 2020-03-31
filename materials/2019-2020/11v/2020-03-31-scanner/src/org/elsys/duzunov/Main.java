package org.elsys.duzunov;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nextToken = scanner.next();
        while (!nextToken.equals("stop")) {
            var student = readStudent(nextToken);
            System.out.println(student.toString());
            nextToken = scanner.next();
        }
    }

    private static Student readStudent(String studentInput) {
        Scanner scanner = new Scanner(studentInput);
        scanner.useDelimiter(",");
        String name = scanner.next();
        int number = scanner.nextInt();
        double averageMark = scanner.nextDouble();
        return new Student(name, number, averageMark);
    }
}
