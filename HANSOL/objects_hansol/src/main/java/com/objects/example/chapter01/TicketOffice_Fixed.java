package com.objects.example.chapter01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TicketOffice_Fixed
{
    private Long amount;
    private List<Ticket> tickets = new ArrayList<>();

    public TicketOffice_Fixed(Long amount, Ticket ... tickets)
    {
        this.amount = amount;
        this.tickets.addAll(Arrays.asList(tickets));
    }

    public void minusAmount(Long amount)
    {
        this.amount -= amount;
    }

    private Ticket getTicket()
    {
        return tickets.remove(0);
    }

    private void plusAmount(Long amount)
    {
        this.amount += amount;
    }

    public void sellTicketTo(Audience_Fixed2 audience_fixed2)
    {
        plusAmount(audience_fixed2.buy(getTicket()));
    }
}
