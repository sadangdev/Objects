package object1;

public class Theater {
	private TicketSeller ticketSeller;
	
	public Theater(TicketSeller ticketSeller) {
		this.ticketSeller = ticketSeller;
	}
	
	public boolean enter(Audience audience) {
		if (audience.getBag().hasInvitation()) {
			Ticket ticket = ticketSeller.getTicketOffice().getTicket();
			audience.getBag().setTicket(ticket);
		} else {
			Ticket ticket = ticketSeller.getTicketOffice().getTicket();
			if(audience.getBag().getAmount() >= ticket.getFee()) {
				audience.getBag().minusAmount(ticket.getFee());
				ticketSeller.getTicketOffice().plusAMount(ticket.getFee());
				audience.getBag().setTicket(ticket);
			} else {
				ticketSeller.getTicketOffice().setTicket(ticket);
			}
		}
		
		return audience.getBag().hasTicket();
	}
}
