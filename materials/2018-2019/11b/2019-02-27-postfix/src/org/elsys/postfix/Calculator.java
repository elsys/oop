package org.elsys.postfix;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Calculator {

    private final Stack<Double> values;

    private final Map<String, Operation> operations;

    public Calculator() {
        values = new Stack<>();
        operations = new HashMap<>();
    }

    public void run(InputStream in, PrintStream out) {
        Scanner scanner = new Scanner(in);
        out.printf("(%d): ", valuesCount());
        while (scanner.hasNext()) {
            String token = scanner.next();
            try {
                Double value = Double.valueOf(token);
                push(value);
            } catch (NumberFormatException e) {
                execute(token);
                out.printf("%f\n", lastValue());
            }
            out.printf("(%d): ", valuesCount());
        }
    }

    private double lastValue() {
        return values.peek();
    }

    private int valuesCount() {
        return values.size();
    }

    public void execute(String token) {
        if (operations.containsKey(token)) {
            Operation operation = operations.get(token);
            operation.execute();
        } else {
            throw new RuntimeException(
                    String.format("Operation %s not found", token)
            );
        }
    }

    public void addOperation(Operation operation) {
        operations.put(operation.getName(), operation);
    }

    public void push(double value) {
        values.push(value);
    }

    public double pop() {
        return values.pop();
    }
}
