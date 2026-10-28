package org.example.ParkingLot;

import java.time.Duration;

public class FixedPriceStartegy implements PricingStartegy{
    @Override
    public double calculatePrice(Ticket ticket) {
        long in_hours = (long) Math.ceil(Duration.between(ticket.timeExited,ticket.timeEntered).toHours());
        return in_hours*100;
    }
}
