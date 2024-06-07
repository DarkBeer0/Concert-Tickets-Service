package users;

import interfaces.Identifiable;
import interfaces.Printable;
import models.Ticket;
import services.TicketService;

public class User implements Printable, Identifiable {
    private String role;
    private int id;
    public User() {
        this.role = "User";
    }

    public void printRole() {
        System.out.println("Role: " + role);
    }

    public Ticket getTicket(TicketService ticketService, String ticketId) {
        return ticketService.getTicketById(ticketId);
    }
    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }
}
