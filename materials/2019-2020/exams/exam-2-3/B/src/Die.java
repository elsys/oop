import java.util.Random;

public class Die {
    private static Random rand = new Random();

    synchronized static int roll() {
        return rand.nextInt(5) + 1;
    }
}