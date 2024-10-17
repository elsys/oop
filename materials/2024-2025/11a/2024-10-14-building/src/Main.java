import org.elsys.bg.House;
import org.elsys.bg.Place;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        House h = new House();
        Place p = new Place();
        p.setArea(25);
        ArrayList<Place> places = new ArrayList<Place>();
        places.add(p);
        h.setPlaces(places);
        System.out.println(h.estimateNetReturn(2));
    }
}
