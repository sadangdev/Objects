package object1;

public class TicketSeller {
	private TicketOffice ticketOffice;
	
	public TicketSeller(TicketOffice ticketOffice) {
		this.ticketOffice = ticketOffice;
	}
	
//	public TicketOffice getTicketOffice() {
//		return ticketOffice;
//	}
	
	public boolean sellTo(Audience audience) {
		if (audience.getBag().hasInvitation()) {
			Ticket ticket = ticketOffice.getTicket();
			audience.getBag().setTicket(ticket);
		} else {
			Ticket ticket = ticketOffice.getTicket();
			if(audience.getBag().getAmount() >= ticket.getFee()) {
				audience.getBag().minusAmount(ticket.getFee());
				ticketOffice.plusAMount(ticket.getFee());
				audience.getBag().setTicket(ticket);
			} else {
				ticketOffice.setTicket(ticket);
			}
		}
		
		return audience.getBag().hasTicket();
	}
}
