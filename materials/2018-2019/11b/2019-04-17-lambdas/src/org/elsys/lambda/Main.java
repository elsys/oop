package org.elsys.lambda;

public class Main {

    public static void main(String[] args) {
        System.out.println(IntegrationService.integrateLn(2, 3, 1000));

        double result1 = new AbstractIntegrable() {
            @Override
            protected double calculate(double x) {
                return Math.log(x);
            }
        }.integrate(2, 3, 1000);
        System.out.println(result1);

        double result2 = IntegrationService.integrate(new MathFunction() {
            @Override
            public double calculate(double x) {
                return Math.log(x);
            }
        }, 2, 3, 1000);
        System.out.println(result2);

        double result3 = IntegrationService.integrate(x -> Math.log(x),
                2, 3, 1000);
        System.out.println(result3);

        double result4 = IntegrationService.integrate((double x) -> {
                    return Math.log(x);
                },
                2, 3, 1000);
        System.out.println(result4);
    }
}
