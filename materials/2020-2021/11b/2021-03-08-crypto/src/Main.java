import org.elsys.mbenov.crypto.Stelacoin;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Stelacoin sc = new Stelacoin(10, new Random());

        System.out.println(sc);

        for(int i =0; i< 10; i++) {
            sc.updatePrice(5, 10);
            System.out.println(sc);
        }
    }
}
