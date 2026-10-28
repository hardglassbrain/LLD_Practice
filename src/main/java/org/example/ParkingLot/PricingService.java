package org.example.ParkingLot;

public class PricingService {

    private final PricingStartegy pricingStartegy;

    public PricingService(PricingStartegy pricingStartegy){
        this.pricingStartegy = pricingStartegy;
    }

    public double calculatePrice(Ticket ticket){
        return pricingStartegy.calculatePrice(ticket);
    }
}
