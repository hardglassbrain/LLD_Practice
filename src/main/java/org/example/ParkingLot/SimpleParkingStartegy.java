package org.example.ParkingLot;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class SimpleParkingStartegy implements ParkingStrategy{


    @Override
    public ParkingSpot findBestParkingSpot(VehicleType vehicleType, List<ParkingSpot> parkingSpots, Map<VehicleType, Set<ParkingSpot>> vehicleTypeToOccupiedSpotMap) {
        Optional<ParkingSpot> spot_assigned = parkingSpots.stream().filter(p -> p.type==vehicleType).filter(s -> !vehicleTypeToOccupiedSpotMap.get(vehicleType).contains(s)).findFirst();
        return spot_assigned.orElse(null);
    }
}
