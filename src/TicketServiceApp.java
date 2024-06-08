import models.Ticket;
import models.TicketPrice;
import services.TicketService;
import sharing.ShareByPhone;
import sharing.ShareByPhoneAndEmail;
import users.Admin;
import users.User;
import utils.NullableWarningProcessor;

public class TicketServiceApp {
    public static void main(String[] args) {
        TicketService ticketService = new TicketService();

        Ticket ticket1 = new Ticket("0001", "Hall1", 101, System.currentTimeMillis(), false, 'A', 5.0, new TicketPrice(100, 10), new ShareByPhone());
        Ticket ticket2 = new Ticket("0002", "Hall2", 102, System.currentTimeMillis(), false, 'B', 5.0, new TicketPrice(120, 20), new ShareByPhoneAndEmail());

        User user = new User();
        Admin admin = new Admin();

        user.printRole();
        admin.printRole();

        Ticket userTicket = user.getTicket(ticketService, "0001");
        admin.checkTicket(userTicket);

        NullableWarningProcessor.checkForNulls(new Ticket());

        ticket1.print();
        ticket2.print();

        ticket1.shared();
        ticket2.shared();
    }
}
