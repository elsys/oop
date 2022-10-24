import java.util.Stack;

//public abstract class Operation implements IOperation {
public abstract class Operation {
    public String op;

    public Operation(String op) {
        this.op = op;
    }

    public abstract void run(Stack<Double> values);
}
