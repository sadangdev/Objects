package com.objects.example.chapter01;

public class TicketSeller_Fixed {
    private TicketOffice ticketOffice;

    public TicketSeller_Fixed(TicketOffice ticketOffice) {
        this.ticketOffice = ticketOffice;
    }
    
    /*remove getter*/
    /*public TicketOffice getTicketOffice() {
        return ticketOffice;
    }*/

    public void sellTo(Audience audience){
        if(audience.getBag().hasInvitation()){
            Ticket ticket = ticketOffice.getTicket();
            audience.getBag().setTicket(ticket);
        }else{
            Ticket ticket = ticketOffice.getTicket();
            audience.getBag().minusAmount(ticket.getFee());
            ticketOffice.plusAmount(ticket.getFee());
            audience.getBag().setTicket(ticket);
        }   
    }

}
