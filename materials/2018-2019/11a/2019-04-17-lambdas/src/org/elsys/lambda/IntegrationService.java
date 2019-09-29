package org.elsys.lambda;

public class IntegrationService {

    public static double integrateLn(double from, double end, int steps) {
        double result = 0;
        double stepSize = (end - from) / steps;
        for (double i = from; i < end; i += stepSize) {
            result += Math.abs(Math.log(i)) * stepSize;
        }
        return result;
    }

    public static double integrateSin(double from, double end, int steps) {
        double result = 0;
        double stepSize = (end - from) / steps;
        for (double i = from; i < end; i += stepSize) {
            result += Math.abs(Math.sin(i)) * stepSize;
        }
        return result;
    }

    public static double integrate(MathFunction func,
                                   double from, double end, int steps) {
        double result = 0;
        double stepSize = (end - from) / steps;
        for (double i = from; i < end; i += stepSize) {
            result += Math.abs(func.calculate(i)) * stepSize;
        }
        return result;
    }
}
