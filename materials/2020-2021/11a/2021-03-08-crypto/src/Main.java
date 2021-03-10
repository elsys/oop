import org.elsys.mbenov.crypto.Marium;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Marium mar = new Marium(20, new Random());

        for(int i = 0; i < 10; i++) {
            mar.updatePrice(5, 10);
            System.out.println(mar.getPrice());
        }
    }
}
