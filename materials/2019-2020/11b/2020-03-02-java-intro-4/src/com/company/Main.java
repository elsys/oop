package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    Skara s = new Skara();
	    List<IBakable> cookies = new ArrayList<IBakable>();
	    /*cookies.add(new Cookie());
        cookies.add(new Cookie("Fat Cookie"));
        cookies.add(new Cookie());
        cookies.add(new Steak());*/

	    Scanner scan = new Scanner(System.in);
        Cookie newCOokie = new Cookie(scan.nextLine());
        cookies.add(newCOokie);

        s.bake(cookies);

        //Food f = (Food)cookies.get(2);
        //f.print_nutritional_value();
    }
}
