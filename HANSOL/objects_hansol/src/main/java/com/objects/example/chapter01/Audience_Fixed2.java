package com.objects.example.chapter01;

public class Audience_Fixed2
{
    private Bag_Fixed bag_fixed;

    public Audience_Fixed2(Bag_Fixed bag_fixed)
    {
        this.bag_fixed = bag_fixed;
    }

    public Long buy(Ticket ticket)
    {
        return bag_fixed.hold(ticket);
    }
}
