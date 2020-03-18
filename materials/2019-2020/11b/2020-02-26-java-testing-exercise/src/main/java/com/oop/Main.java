package main.java.com.oop;

public class Main {

    public static void main(String[] args) {
        String expr = "";

        for (String arg : args) {
            expr += arg + " ";
        }

        int index_of_comma = expr.indexOf(',');
        int index_of_space = expr.indexOf(' ');

        Point A = new Point(Double.parseDouble(expr.substring(0, index_of_comma)),
                            Double.parseDouble(expr.substring(++index_of_comma, index_of_space)));
        Point B;

        if (expr.length() > 6) {
            index_of_space++;
            index_of_comma = expr.indexOf(',', index_of_comma);

            B = new Point(Double.parseDouble(expr.substring(index_of_space++, index_of_comma)),
                          Double.parseDouble(expr.substring(++index_of_comma, expr.indexOf(' ', index_of_comma+1))));

            if (args.length == 3) {
                index_of_space += 2;
                index_of_comma = expr.indexOf(',', index_of_comma);

                Point C = new Point(Double.parseDouble(expr.substring(index_of_space, index_of_comma)),
                                    Double.parseDouble(expr.substring(index_of_comma+1, expr.indexOf(' ', index_of_comma+1))));

                Triangle t = new Triangle(A, B, C);

                t.printShape();
            } else if (args.length == 2) {
                Rectangle r = new Rectangle(A, B);

                r.printShape();
            }
        } else {
            Circle c1 = new Circle(A, Double.parseDouble(expr.substring(index_of_space)));

            c1.printShape();
        }
    }
}
