import java.time.Instant;

public class TicketService {
    public static void main(String[] args) {
        Ticket emptyTicket = new Ticket();
        System.out.println("Empty Ticket: " + emptyTicket);

        TicketPrice fullTicketPrice = new TicketPrice(150, 0);
        Ticket fullTicket = new Ticket("AB12", "BigHall", 123, Instant.now().getEpochSecond(), true, 'B', 5.5, fullTicketPrice);
        System.out.println("Full Ticket: " + fullTicket);

        Ticket limitedTicket = new Ticket("SmallHall", 456, Instant.now().getEpochSecond());
        System.out.println("Limited Ticket: " + limitedTicket);
    }
}
