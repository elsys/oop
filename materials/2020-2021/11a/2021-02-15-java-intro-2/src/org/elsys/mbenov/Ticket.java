package org.elsys.mbenov;

import java.util.Date;

public class Ticket {
    static int ticketCount = 0;

    private int number;
    private String service;
    private Date issueDate;

    int getNumber() {
        return number;
    }

    public String getService() {
        return service;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public Ticket(String service) {
        this.number = ++ticketCount;
        this.service = service;
        this.issueDate = new Date();
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "number=" + number +
                ", service='" + service + '\'' +
                ", issueDate=" + issueDate +
                '}';
    }
}
