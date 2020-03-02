package main.java.com.elsys;

import static java.lang.StrictMath.abs;

public class Rectangle {
    Point A;
    Point B;
    double a;
    double b;

    public Rectangle(Point A, Point B){
        this.A=A;
        this.B=B;
        a=abs(A.x-B.x);
        b=abs(A.y-B.y);
    }

    public double getPerimeter(){
        return (double) ((a+b)*2);
    }
    public double getArea(){
        return (double) (a*b);
    }
}
