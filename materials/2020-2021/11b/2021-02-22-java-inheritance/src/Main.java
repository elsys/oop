import org.elsys.mbenov.*;

import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Ruler myRuler = new Ruler("Jiin Yuzang", 34);
        Imperator myEmperor = new Imperator("Todor", 60);

        System.out.println(myRuler.canTravel());

        List<ICommunist> voters = new LinkedList();
        voters.add(myRuler);
        voters.add(new Citizen("Ivan", 23));
        voters.add(new Citizen("Petar", 32));

        for (ICommunist voter : voters){
            voter.vote();
        }

        System.out.println(myRuler.canPerformGenocide());
        System.out.println(myEmperor.canPerformGenocide());

//        for(int i = 0; i < voters.size(); i++) {
//            ICommunist voter = voters.get(i);
//            voter.vote();
//        }
    }
}
