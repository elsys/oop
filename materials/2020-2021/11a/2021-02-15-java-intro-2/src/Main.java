//import jdk.net.*;
//import jdk.net.ExtendedSocketOptions;
//import jdk.net.NetworkPermission;
//import jdk.net.Sockets;
import org.elsys.mbenov.Ticket;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Ticket ticket1 = new Ticket("Смяна регистрационен номер");
        Ticket ticket2 = new Ticket("Смяна регистрационен номер");
        Ticket ticket3 = new Ticket("Смяна регистрационен номер");

       /* System.out.println(ticket1);
        System.out.println(ticket2);
        System.out.println(ticket3);*/

        Ticket[] tickets = new Ticket[3];
        tickets[0] = ticket1;
        tickets[1] = ticket2;
        tickets[2] = ticket3;

        Ticket[] tickets2 = {ticket1, ticket2, ticket3};

        for(int i = 0; i < tickets.length; i++) {
            System.out.println(tickets[i]);
        }

        for(Ticket ticket : tickets) {
            System.out.println(ticket);
        }
//        myTicket.issueDate
//        Ticket.ticketCout

//        ExtendedSocketOptions opt;
//        NetworkPermission perm;
//        Sockets sock;
    }
}