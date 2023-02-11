public class Line {
    private float a, b, c, d;
    private String name;

    public Line(float a, float b, float c, float d, String name) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Line{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                ", d=" + d +
                ", name='" + name + '\'' +
                '}';
    }
}
