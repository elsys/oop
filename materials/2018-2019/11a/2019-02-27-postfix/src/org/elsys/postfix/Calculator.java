package org.elsys.postfix;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Calculator {

    private Stack<Double> values;
    private Map<String, Operation> operations;

    public Calculator() {
        values = new Stack<>();
        operations = new HashMap<>();
    }

    public void run(InputStream in, PrintStream out) {
        Scanner scanner = new Scanner(in);
        out.printf("(%d): ", stackSize());
        while (scanner.hasNext()) {
            String token = scanner.next();
            try {
                Double value = Double.valueOf(token);
                push(value);
            } catch (NumberFormatException e) {
                execute(token);
                out.printf("%f\n", lastValue());
            }
            out.printf("(%d): ", stackSize());
        }
    }

    private int stackSize() {
        return values.size();
    }

    private double lastValue() {
        return values.peek();
    }

    public void push(double value) {
        values.push(value);
    }

    public void execute(String token) {
        Operation operation = operations.get(token);
        if (operation == null) {
            throw new RuntimeException(
                    String.format("Operation %s not found", token)
            );
        }
        operation.execute();
    }

    public void addOperation(Operation operation) {
        operations.put(operation.getName(), operation);
    }

    public double pop() {
        return values.pop();
    }
}
