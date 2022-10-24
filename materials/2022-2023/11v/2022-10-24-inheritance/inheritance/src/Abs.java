public class Abs extends UnaryOperation {
    public Abs() {
        super("abs");
    }

    @Override
    public double run(double value) {
        return Math.abs(value);
    }
}
