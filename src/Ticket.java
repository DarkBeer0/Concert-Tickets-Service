import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class Ticket {
    private String id;
    private String concertHall;
    private int eventCode;
    private long time;
    private boolean isPromo;
    private char stadiumSector;
    private double maxAllowedBackpackWeight;
    private final LocalDateTime creationTime;
    private TicketPrice ticketPrice;

    public Ticket(String id, String concertHall, int eventCode, long time, boolean isPromo, char stadiumSector, double maxAllowedBackpackWeight, TicketPrice ticketPrice) {
        this.id = id;
        this.concertHall = concertHall;
        this.eventCode = eventCode;
        this.time = time;
        this.isPromo = isPromo;
        this.stadiumSector = stadiumSector;
        this.maxAllowedBackpackWeight = maxAllowedBackpackWeight;
        this.ticketPrice = ticketPrice;
        this.creationTime = LocalDateTime.now(ZoneOffset.UTC);
    }


    public Ticket(String concertHall, int eventCode, long time) {
        this.concertHall = concertHall;
        this.eventCode = eventCode;
        this.time = time;
        this.creationTime = LocalDateTime.now(ZoneOffset.UTC);
    }

    public Ticket() {
        this.creationTime = LocalDateTime.now(ZoneOffset.UTC);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (id.length() > 4)
            throw new IllegalArgumentException("ID length exceeds 4 characters.");
        this.id = id;
    }

    public String getConcertHall() {
        return concertHall;
    }

    public void setConcertHall(String concertHall) {
        if (concertHall.length() > 10 || concertHall.isEmpty())
            throw new IllegalArgumentException("Concert hall name length exceeds 10 characters.");
        this.concertHall = concertHall;
    }

    public int getEventCode() {
        return eventCode;
    }

    public void setEventCode(int eventCode) {
        if (eventCode < 100 || eventCode > 999)
            throw new IllegalArgumentException("Event code must be a 3-digit number.");
        this.eventCode = eventCode;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public boolean isPromo() {
        return isPromo;
    }

    public void setPromo(boolean promo) {
        isPromo = promo;
    }

    public char getStadiumSector() {
        return stadiumSector;
    }

    public void setStadiumSector(char stadiumSector) {
        if (stadiumSector < 'A' || stadiumSector > 'C')
            throw new IllegalArgumentException("Stadium sector must be between 'A' and 'C'.");
        this.stadiumSector = stadiumSector;

    }

    public double getMaxAllowedBackpackWeight() {
        return maxAllowedBackpackWeight;
    }

    public void setMaxAllowedBackpackWeight(double maxAllowedBackpackWeight) {
        if (maxAllowedBackpackWeight < 0)
            throw new IllegalArgumentException("Backpack weight cannot be less than 0.");
        this.maxAllowedBackpackWeight = maxAllowedBackpackWeight;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public TicketPrice getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(TicketPrice ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id='" + id + '\'' +
                ", concertHall='" + concertHall + '\'' +
                ", eventCode=" + eventCode +
                ", time=" + time +
                ", isPromo=" + isPromo +
                ", stadiumSector=" + stadiumSector +
                ", maxAllowedBackpackWeight=" + maxAllowedBackpackWeight +
                ", creationTime=" + creationTime +
                ", ticketPrice=" + ticketPrice +
                '}';
    }
}
