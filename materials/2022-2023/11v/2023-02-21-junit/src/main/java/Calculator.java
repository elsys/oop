import java.util.Random;

public class Calculator {
    private int a;

    public Calculator(int a) {
        this.a = a;
    }

    public int add(int b) {
        Random r = new Random();
        return r.nextInt() % 14;
    }
}
