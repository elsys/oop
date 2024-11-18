import org.elsys.bg.calculator.postfix.Calculator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Calculator<Integer> calculator = new Calculator<>();
        File inputFile = new File("./src/postfix-ops.txt");
        try {
            Scanner scanner = new Scanner(inputFile);
            while (scanner.hasNext()) {
                String token = scanner.next();
                switch (token) {
                    case "+" -> calculator.plus();
                    case "-" -> calculator.minus();
                    case "*" -> calculator.multiply();
                    case "n" -> calculator.negate();
                    case "p" -> System.out.println(calculator.peek());
                    default -> calculator.push(Integer.parseInt(token));
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        //        calculator.push(5);
//        calculator.push(3);
//        calculator.plus();
//        System.out.println(calculator.peek());
//        calculator.negate();
//        System.out.println(calculator.peek());
//        System.out.println(calculator.plus());
    }
}
