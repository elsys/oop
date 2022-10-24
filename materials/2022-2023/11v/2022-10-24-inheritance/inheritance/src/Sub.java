import java.util.Stack;

public class Sub
        extends Operation {
    public Sub() {
        super("-");
    }

    @Override
    public void run(Stack<Double> values) {
        values.add(values.pop() - values.pop());
    }
}
