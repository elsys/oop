import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private Random rand;

    public static void main(String[] args) {
        Main m = new Main(new Random());
        m.calc();
    }

    public Main(Random rand) {
        this.rand = rand;
    }

    public void calc() {
        System.out.println(rand.nextInt());
        Scanner sc = new Scanner(System.in);
        System.out.println(sc.nextInt());
    }
}
