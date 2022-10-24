import java.util.Stack;

public abstract class UnaryOperation extends Operation {
    public UnaryOperation(String op) {
        super(op);
    }
    @Override
    public void run(Stack<Double> values) {
        values.add(run(values.pop()));
    }

    public abstract double run(double value);
}
