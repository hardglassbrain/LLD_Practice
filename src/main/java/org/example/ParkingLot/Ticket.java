package org.example.ParkingLot;

import java.time.LocalDateTime;
import java.util.UUID;

public class Ticket {
    String id;
    ParkingSpot spot;
    Vehicle vehicle;
    LocalDateTime timeEntered;
    LocalDateTime timeExited;

    public Ticket(ParkingSpot spot, Vehicle vehicle, LocalDateTime timeEntered) {
        this.id = UUID.randomUUID().toString();
        this.spot = spot;
        this.vehicle = vehicle;
        this.timeEntered = timeEntered;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getTimeExited() {
        return timeExited;
    }

    public void setTimeExited(LocalDateTime timeExited) {
        this.timeExited = timeExited;
    }

    public LocalDateTime getTimeEntered() {
        return timeEntered;
    }

    public void setTimeEntered(LocalDateTime timeEntered) {
        this.timeEntered = timeEntered;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public ParkingSpot getSpot() {
        return spot;
    }

    public void setSpot(ParkingSpot spot) {
        this.spot = spot;
    }
}
