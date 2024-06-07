import models.Ticket;
import services.TicketService;
import sharing.ShareByPhone;
import sharing.ShareByPhoneAndEmail;
import sharing.Shareable;
import users.Admin;
import users.User;
import utils.NullableWarningProcessor;

public class TicketServiceApp {
    public static void main(String[] args) {
        TicketService ticketService = new TicketService();

        Shareable shareByPhone = new ShareByPhone();
        Shareable shareByPhoneAndEmail = new ShareByPhoneAndEmail();

        shareByPhone.share();
        shareByPhoneAndEmail.share();

        User user = new User();
        Admin admin = new Admin();

        user.printRole();
        admin.printRole();

        Ticket ticket = user.getTicket(ticketService, "0001");
        admin.checkTicket(ticket);
        NullableWarningProcessor.checkForNulls(new Ticket());
    }
}
