package com.objects.example.chapter01;

public class TicketSeller_Fixed3 {
    private TicketOffice_Fixed ticketOffice_fixed;

    public TicketSeller_Fixed3(TicketOffice_Fixed ticketOffice_fixed) {
        this.ticketOffice_fixed = ticketOffice_fixed;
    }

    /*remove getter*/
    /*public TicketOffice getTicketOffice() {
        return ticketOffice;
    }*/

    public void sellTo(Audience_Fixed2 audience_fixed2){
       ticketOffice_fixed.sellTicketTo(audience_fixed2);
    }

}
