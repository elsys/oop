package org.elsys.lambda;

public abstract class AbstractIntegrable {

    public double integrate(double from, double end, int steps) {
        double result = 0;
        double stepSize = (end - from) / steps;
        for (double i = from; i < end; i += stepSize) {
            result += Math.abs(Math.log(i)) * stepSize;
        }
        return result;
    }

    protected abstract double calculate(double arg);
}
