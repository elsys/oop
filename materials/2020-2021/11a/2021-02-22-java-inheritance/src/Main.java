import org.elsys.mbenov.Dealer;
import org.elsys.mbenov.ICarrier;
import org.elsys.mbenov.Mule;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Collection<ICarrier> carriers = new LinkedList<>();
        carriers.add(new Dealer(100, "Go6o", "Qdene"));
        carriers.add(new Mule(15, "Kri$", "Zeleno"));

        for (ICarrier carrier : carriers) {
            carrier.carry();
        }
    }
}
