import java.util.Vector;

public class Vector2D {
    public static Vector2D unitVector(Vector2D v) {
        float r = v.getMagnitude();
        return new Vector2D(v.x / r, v.y / r);
    }

    public float x = 0f;
    public float y = 0f;

    public Vector2D() {}

    public Vector2D(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getMagnitude() {
//        double a = 5;
//        return (float)a;
        return (float)Math.sqrt(x*x + y*y);
    }

    public Vector2D add(Vector2D other) {
        return new Vector2D(x + other.x, y + other.y);
    }

    public Vector2D subtract(Vector2D other) {
        return new Vector2D(x - other.x, y - other.y);
    }

    public Vector2D multiply(float other) {
        return new Vector2D(x * other, y * other);
    }

    public Vector2D divide(float mass) {
        return multiply(1 / mass);
    }

    @Override
    public String toString() {
        return "Vector2D{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
