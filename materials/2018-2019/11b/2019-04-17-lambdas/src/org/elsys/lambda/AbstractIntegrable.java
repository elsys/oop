package org.elsys.lambda;

public abstract class AbstractIntegrable {

    public double integrate(double from, double to, int steps) {
        double stepSize = (to - from) / steps;
        double result = 0;
        for (double x = from; x < to; x+=stepSize) {
            result += Math.abs(calculate(x)) * stepSize;
        }
        return result;
    }

    protected abstract double calculate(double x);
}
