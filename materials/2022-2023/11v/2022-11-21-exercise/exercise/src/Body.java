public class Body {
    public Vector2D pos;
    public String name;
    public float mass;

    public Body(String name, float x, float y, float mass) {
        this.pos = new Vector2D(x, y);
        this.name = name;
        this.mass = mass;
    }

    public Vector2D getForce(Body other) {
        Vector2D distance = other.pos.subtract(pos);
        float r = distance.getMagnitude();

        float F = (mass * other.mass) / (r*r);

        //Vector2D direction = new Vector2D(distance.x / r, distance.y / r);
        Vector2D direction = Vector2D.unitVector(distance);

        return direction.multiply(F);
    }

    public void applyForce(Vector2D F) {
        System.out.println("Apply " + F + " to " + name);
        Vector2D a = F.divide(mass);
        pos = pos.add(a);
    }

}
