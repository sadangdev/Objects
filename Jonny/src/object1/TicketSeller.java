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
		Long fee = audience.buy(ticketOffice.getTicket());
		
		if(fee >= 0) {
			ticketOffice.plusAmount(fee);
			return true;
		} else {
			return false;
		}
		
	}
}
