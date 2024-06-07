package users;

import interfaces.Identifiable;
import interfaces.Printable;
import models.Ticket;

public class Admin implements Printable, Identifiable {
    private String role;
    private int id;
    public Admin() {
        this.role = "Admin";
    }

    public void printRole() {
        System.out.println("Role: " + role);
    }

    public void checkTicket(Ticket ticket) {
        System.out.println("Checking ticket: " + ticket);
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
