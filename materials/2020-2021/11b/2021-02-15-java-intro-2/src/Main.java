//import jdk.net.*;
import org.elsys.mbenov.Ticket;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Ticket ticket1 = new Ticket("Храна");
        Ticket ticket2 = new Ticket("Храна");
        Ticket ticket3 = new Ticket("Храна");

       /* System.out.println(ticket1);
        System.out.println(ticket2);
        System.out.println(ticket3);*/

        Ticket[] tickets = new Ticket[3]; // = {ticket1, ticket2, ticket3};
        tickets[0] = ticket1;
        tickets[1] = ticket2;
        tickets[2] = ticket3;

        //for(int i = 0; i < tickets.length; i++) {
        //  Ticket ticket = tickets[0];
        for(Ticket ticket : tickets) {
            System.out.println(ticket);
        }

//        ExtendedSocketOptions opt;
//        NetworkPermission netPerm;
//        Sockets sock;
    }
}
