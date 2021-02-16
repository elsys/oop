package org.elsys.mbenov;

import java.util.Date;

public class Ticket {
    private static int ticketCount = 1;

    private String service;
    private int ticketNumber;
    private Date issueDate;

    public String getService() {
        return service;
    }

    public int getTicketNumber() {
        return ticketNumber;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public Ticket(String service) {
        this.service = service;
        this.ticketNumber = ticketCount++;
        this.issueDate = new Date();
    }

    //\n \t "asd \\ \""
    @Override
    public String toString() {
        return "Ticket{" +
                "service='" + service + '\'' +
                ", ticketNumber=" + ticketNumber +
                ", issueDate=" + issueDate +
                '}';
    }
}