package main.java.com.elsys;

import static java.lang.StrictMath.pow;

public class Circle {
    Point O;
    double r;

    Circle(Point O, int r){
        this.O=O;
        this.r=r;
    }
    public double getPerimeter(){
        return (double) (6.28*r);
    }
    public double getArea(){
        return (double) ((double) 3.14*pow(r, 2));
    }
}
