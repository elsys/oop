package org.elsys.bg.calculator.postfix;

import java.util.List;
import java.util.Map;
import java.util.Stack;
public class Calculator<T extends Number> {
     Stack<T> numbers;

    public Calculator() {
        numbers = new Stack<T>();
    }

    public int push(T value) {
        numbers.push(value);
        return numbers.size();
    }

    private T doubleToT(double value) {
        return (T) Double.valueOf(value);
    }

    public T peek() {
        return numbers.peek();
    }

    private int _push(double value) {
        return push(doubleToT(value));
    }

    public int plus() {
        if (numbers.size() < 2) {
            return -1;
        }
        T first = numbers.pop();
        T second = numbers.pop();
        return _push(first.doubleValue() + second.doubleValue());
    }

    public int multiply() {
        if (numbers.size() < 2) {
            return -1;
        }
        T first = numbers.pop();
        T second = numbers.pop();
        return _push(first.doubleValue() * second.doubleValue());
    }

    public int minus() {
        negate();
        return plus();
    }

    public int negate() {
        if (numbers.size() < 1) {
            return -1;
        }
        T first = numbers.pop();
        return _push(-first.doubleValue());
    }
}
