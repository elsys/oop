package org.elsys.lambda;

public class Main {

    public static void main(String[] args) {
        System.out.println(IntegrationService.integrateLn(1, 2, 10));

        double result = new AbstractIntegrable() {
            @Override
            protected double calculate(double arg) {
                return Math.log(arg);
            }
        }.integrate(1, 2, 10);
        System.out.println(result);

        double result2 = IntegrationService.integrate(new MathFunction() {
            @Override
            public double calculate(double arg) {
                return Math.log(arg);
            }
        }, 1, 2, 10);
        System.out.println(result2);

        double result3 = IntegrationService.integrate(arg -> Math.log(arg),
                1, 2, 10);
        System.out.println(result3);

        double result4 = IntegrationService.integrate(arg -> {
            return Math.log(arg);
        }, 1, 2, 10);
        System.out.println(result4);
    }
}
