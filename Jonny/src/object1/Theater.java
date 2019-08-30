package object1;

public class Theater {
	private TicketSeller ticketSeller;
	
	public Theater(TicketSeller ticketSeller) {
		this.ticketSeller = ticketSeller;
	}
	
	public boolean enter(Audience audience) {
		return ticketSeller.sellTo(audience);
	}
}
