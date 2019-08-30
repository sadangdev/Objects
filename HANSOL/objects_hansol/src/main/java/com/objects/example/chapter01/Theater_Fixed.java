package com.objects.example.chapter01;

public class Theater_Fixed {
    private TicketSeller_Fixed ticketSeller_fixed;

    public Theater_Fixed(TicketSeller_Fixed ticketSeller_fixed) {
        this.ticketSeller_fixed = ticketSeller_fixed;
    }
    //fixed_example
    public void enter(Audience audience){
        /*if(audience.getBag().hasInvitation()){
            Ticket ticket = ticketSeller.getTicketOffice().getTicket();
            audience.getBag().setTicket(ticket);
        }else{
            Ticket ticket = ticketSeller.getTicketOffice().getTicket();
            audience.getBag().minusAmount(ticket.getFee());
            ticketSeller.getTicketOffice().plusAmount(ticket.getFee());
            audience.getBag().setTicket(ticket);
        }*/
        ticketSeller_fixed.sellTo(audience);

    }

}
