package main.java.com.elsys;

import static java.lang.StrictMath.pow;
import static java.lang.StrictMath.sqrt;

public class Triangle {
    Point A;
    Point B;
    Point C;
    double a;
    double b;
    double c;
    double P;
    double Area;

    public Triangle(Point A,
                    Point B,
                    Point C){

        this.A=A;
        this.B=B;
        this.C=C;
        a=sqrt(pow((A.x-B.x),2)+pow((A.y-B.y),2));
        b=sqrt(pow((C.x-B.x),2)+pow((C.y-B.y),2));
        c=sqrt(pow((C.x - A.x),2)+pow((C.y - A.y),2));
    }


    double getPerimeter(){
        return a+b+c;
    }
    public double getArea(){
        double p= (double) ((a+b+c)/2);
        Area= (double) sqrt(p*(p-a)*(p-b)*(p-c));
        return Area;
    }
}
