import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Calculator {
    private List<Operation> ops = new ArrayList<>();

    public void addOp(Operation op) {
        ops.add(op);
    }

    public double run(String expr) {
        String[] tokens = expr.split(" ");
        Stack<Double> values = new Stack<>();

        for(String token : tokens) {
//            if(isDouble(token)) {
//                values.add(Double.parseDouble(token))
//            } else {
//                runOperation()
//            }

            try {
                double value = Double.parseDouble(token);
                values.add(value);
            } catch(NumberFormatException ex) {
                for(Operation op : ops) {
                    if(op.op.equals(token)) {
                        op.run(values);
                        break;
                    }
                }
            }
        }

        return values.pop();
    }
}










