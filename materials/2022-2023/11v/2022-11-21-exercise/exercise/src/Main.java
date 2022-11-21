import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class Main {
    public static void main(String[] args) {
//        System.out.println(1.0f / 0f);

        List<Body> bodies = new LinkedList<>();

        Scanner sc = new Scanner(System.in);

        while(sc.hasNext()) {
            System.out.println("Next body:");
            String name = sc.next();

            if(name.equals("start")) break;

            float x = sc.nextFloat();
            float y = sc.nextFloat();
            float m = sc.nextFloat();

            bodies.add(new Body(name, x, y, m));
        }

        System.out.println("Start simulation:");

        while(true) {
            for (Body body : bodies) {
                for (Body other : bodies) {
                    if (body == other) continue;

                    body.applyForce(body.getForce(other));
                }
            }
        }
    }
}
