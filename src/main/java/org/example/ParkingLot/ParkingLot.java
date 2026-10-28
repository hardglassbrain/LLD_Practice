package org.example.ParkingLot;

import java.time.LocalDateTime;
import java.util.*;

public class ParkingLot {
    List<ParkingSpot> parkingSpots;
    Map<VehicleType, Set<ParkingSpot>> vehicleTypeToOccupiedSpotMap;
    ParkingStrategy parkingStrategy;
    PricingService pricingService;

    public ParkingLot(ParkingStrategy parkingStrategy){
        this.parkingStrategy = parkingStrategy;
        this.pricingService = new PricingService(new FixedPriceStartegy());
        this.parkingSpots = new ArrayList<>();
        vehicleTypeToOccupiedSpotMap = new HashMap<>();
        initializeMap(vehicleTypeToOccupiedSpotMap);
    }

    private void initializeMap(Map<VehicleType, Set<ParkingSpot>> vehicleTypeToOccupiedSpotMap) {
        for(VehicleType type : VehicleType.values()){
            vehicleTypeToOccupiedSpotMap.put(type,new HashSet<>());
        }
    }

    public void addParkingSpots(ParkingSpot ps){
        parkingSpots.add(ps);
    }

    public Ticket bookParkingSpot(Vehicle vehicle) throws Exception {
        VehicleType type = vehicle.getVehicleType();
        ParkingSpot parkingSpot = findBestParkingSpot(type, parkingSpots, vehicleTypeToOccupiedSpotMap);
        if(parkingSpot == null) throw new Exception("No ParkingSpot Available");
        vehicleTypeToOccupiedSpotMap.get(type).add(parkingSpot);
        System.out.println("Parking spot "+parkingSpot.id+" booked");
        return new Ticket(parkingSpot,vehicle, LocalDateTime.now());
    }

    public void exit(Ticket ticket){
        ticket.setTimeExited(LocalDateTime.now());
        vehicleTypeToOccupiedSpotMap.get(ticket.vehicle.getVehicleType()).remove(ticket.getSpot());
        double dollars = pricingService.calculatePrice(ticket);
        System.out.println(dollars);

    }

    private ParkingSpot findBestParkingSpot(VehicleType type,List<ParkingSpot> parkingSpots, Map<VehicleType, Set<ParkingSpot>> vehicleTypeToOccupiedSpotMap ) {
        return parkingStrategy.findBestParkingSpot(type,parkingSpots,vehicleTypeToOccupiedSpotMap);
    }
}
