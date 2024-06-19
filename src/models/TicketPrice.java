package models;

public class TicketPrice {
    private int dollars;
    private int cents;

    public TicketPrice(int dollars, int cents) {
        this.dollars = dollars;
        this.cents = cents;
    }

    public int getDollars() {
        return dollars;
    }

    public int getCents() {
        return cents;
    }

    @Override
    public String toString() {
        return String.format("$%d.%02d", dollars, cents);
    }
}
