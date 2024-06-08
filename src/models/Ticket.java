package models;

import annotations.NullableWarning;
import interfaces.Printable;
import interfaces.Shareable;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Objects;

public class Ticket implements Printable {
    @NullableWarning
    private String id;
    private final String concertHall;
    private final int eventCode;
    private long time;
    private final boolean isPromo;
    private char stadiumSector;
    private final double maxAllowedBackpackWeight;
    private final LocalDateTime creationTime;
    private final TicketPrice ticketPrice;
    private Shareable shareStrategy;

    public Ticket(String id, String concertHall, int eventCode, long time, boolean isPromo, char stadiumSector, double maxAllowedBackpackWeight, TicketPrice ticketPrice, Shareable shareStrategy) {
        this.id = id;
        this.concertHall = concertHall;
        this.eventCode = eventCode;
        this.time = time;
        this.isPromo = isPromo;
        this.stadiumSector = stadiumSector;
        this.maxAllowedBackpackWeight = maxAllowedBackpackWeight;
        this.ticketPrice = ticketPrice;
        this.creationTime = LocalDateTime.now(ZoneOffset.UTC);
        this.shareStrategy = shareStrategy;
    }

    public Ticket(String concertHall, int eventCode, long time) {
        this(null, concertHall, eventCode, time, false, 'A', 0.0, null, null);
    }

    public Ticket() {
        this(null, "", 0, 0, false, 'A', 0.0, null, null);
    }

    public String getId() {
        return id;
    }
    public String getConcertHall() {
        return concertHall;
    }

    public int getEventCode() {
        return eventCode;
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

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public TicketPrice getTicketPrice() {
        return ticketPrice;
    }

    public void shared() {
        if (shareStrategy == null) {
            System.out.println("No sharing strategy set.");
            return;
        }
        shareStrategy.share();
    }

    @Override
    public void print() {
        toString();
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return eventCode == ticket.eventCode &&
                time == ticket.time &&
                isPromo == ticket.isPromo &&
                Double.compare(ticket.maxAllowedBackpackWeight, maxAllowedBackpackWeight) == 0 &&
                Objects.equals(id, ticket.id) &&
                Objects.equals(concertHall, ticket.concertHall) &&
                stadiumSector == ticket.stadiumSector &&
                Objects.equals(creationTime, ticket.creationTime) &&
                Objects.equals(ticketPrice, ticket.ticketPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, concertHall, eventCode, time, isPromo, stadiumSector, maxAllowedBackpackWeight, creationTime, ticketPrice);
    }
}
