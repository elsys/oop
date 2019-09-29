package org.elsys.lambda;

public class IntegrationService {

    public static double integrateLn(double from, double to, int steps) {
        double stepSize = (to - from) / steps;
        double result = 0;
        for (double x = from; x < to; x+=stepSize) {
            result += Math.abs(Math.log(x)) * stepSize;
        }
        return result;
    }

    public static double integrate(MathFunction func, double from, double to, int steps) {
        double stepSize = (to - from) / steps;
        double result = 0;
        for (double x = from; x < to; x+=stepSize) {
            result += Math.abs(func.calculate(x)) * stepSize;
        }
        return result;
    }
}
