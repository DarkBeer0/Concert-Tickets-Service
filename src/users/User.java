package users;
import interfaces.Printable;
import models.Ticket;
import services.TicketService;

public class User implements Printable {
    private String role;
    public User() {
        this.role = "User";
    }

    public void printRole() {
        System.out.println("Role: " + role);
    }

    public Ticket getTicket(TicketService ticketService, String ticketId) {
        return ticketService.getTicketById(ticketId);
    }
}
