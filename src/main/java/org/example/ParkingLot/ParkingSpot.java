package org.example.ParkingLot;

public class ParkingSpot {
    String id;
    VehicleType type;

    public String getId() {
        return id;
    }

    public ParkingSpot(String id, VehicleType type){
        this.id = id;
        this.type = type;
    }

    public void setId(String id) {
        this.id = id;
    }

    public VehicleType getType() {
        return type;
    }

    public void setType(VehicleType type) {
        this.type = type;
    }
}
