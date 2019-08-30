package object1;

public class Main {

	public static void main(String[] args) {
		Ticket ticket1 = new Ticket(100L);
		
		TicketOffice ticketOffice = new TicketOffice(100L, ticket1, ticket1, ticket1, ticket1);
		TicketSeller ticketSeller = new TicketSeller(ticketOffice);
		
		Theater theater = new Theater(ticketSeller);
		
		Audience audience1 = new Audience(new Bag(50L));
		Audience audience2 = new Audience(new Bag(new Invitation(), 0L));
		Audience audience3 = new Audience(new Bag(100L));
		Audience audience4 = new Audience(new Bag(200L));
		
		System.out.println(theater.enter(audience1)); // false 초대장x, 돈x
		System.out.println(theater.enter(audience2)); // true 초대장o, 돈x
		System.out.println(theater.enter(audience3)); // true 초대장x, 돈o
		System.out.println(theater.enter(audience4)); // true 초대장x, 돈o
	}

}
