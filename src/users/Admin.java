package users;

import abstracts.Identifiable;
import interfaces.Printable;
import models.Ticket;

public class Admin extends Identifiable implements Printable {
    private String role;
    public Admin() {
        this.role = "Admin";
    }

    public void printRole() {
        System.out.println("Role: " + role);
    }

    public void checkTicket(Ticket ticket) {
        System.out.println("Checking ticket: " + ticket);
    }
}
