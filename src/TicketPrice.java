public class TicketPrice {
    private int dollars;
    private int cents;

    public TicketPrice(int dollars, int cents) {
        if (dollars < 0 || cents < 0 || cents >= 100)
            throw new IllegalArgumentException("Invalid price values. Dollars should be non-negative, and cents should be between 0 and 99.");
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
