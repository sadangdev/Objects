package object1;

public class Audience {
	private Bag bag;
	
	public Audience(Bag bag) {
		this.bag = bag;
	}
	
//	public Bag getBag() {
//		return bag;
//	}
	
	public Long buy(Ticket ticket) {
		if (bag.hasInvitation()) {
			bag.setTicket(ticket);
			return 0L;
		} else {
			if(bag.getAmount() >= ticket.getFee()) {
				bag.minusAmount(ticket.getFee());
				bag.setTicket(ticket);
				return ticket.getFee();
			} else {
				return -1L;
			}
		}
	}
	
}
