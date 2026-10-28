package org.example.ParkingLot;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface ParkingStrategy {
    ParkingSpot findBestParkingSpot(VehicleType vehicleType, List<ParkingSpot> parkingSpots, Map<VehicleType, Set<ParkingSpot>> vehicleTypeToOccupiedSpotMap);
}
