package services;

import models.Ticket;
import models.TicketPrice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TicketService {
    private Map<String, Ticket> tickets;
    public TicketService() {
        tickets = new HashMap<>();
        for (int i = 1; i <= 10; i++) {
            String id = String.format("%04d", i);
            Ticket ticket = new Ticket(id, "Hall" + (i % 3 + 1), 100 + i, System.currentTimeMillis(), false, (char)('A' + i % 3), 5.0, new TicketPrice(100, 10));
            tickets.put(id, ticket);
        }
    }
    public Ticket getTicketById(String id) {
        return tickets.get(id);
    }

    public List<Ticket> getTicketsByStadiumSector(char stadiumSector) {
        return tickets.values().stream()
                .filter(ticket -> ticket.getStadiumSector() == stadiumSector)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        TicketService ticketService = new TicketService();
        System.out.println("Tickets in sector A: " + ticketService.getTicketsByStadiumSector('A'));
    }
}
