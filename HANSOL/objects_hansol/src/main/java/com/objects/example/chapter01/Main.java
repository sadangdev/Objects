package com.objects.example.chapter01;

import java.util.ArrayList;
import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        Long longData = 5000L;
        Bag bag = new Bag(longData);
        Audience audience = new Audience(bag);
        List<Ticket> tickets = new ArrayList<>();
        Ticket ticket = new Ticket();
        ticket.setFee(longData);
        TicketOffice ticketOffice = new TicketOffice(longData,ticket);
        TicketSeller ticketSeller = new TicketSeller(ticketOffice);
        Theater theater = new Theater(ticketSeller);
        theater.enter(audience);
    }
}
