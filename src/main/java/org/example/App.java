package org.example;


import org.example.ParkingLot.*;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception {
//        Game.playGame();
        ParkingLot parkingLot = new ParkingLot(new SimpleParkingStartegy());
        parkingLot.addParkingSpots(new ParkingSpot("123", VehicleType.CAR));
        parkingLot.addParkingSpots(new ParkingSpot("124", VehicleType.CAR));
        parkingLot.addParkingSpots(new ParkingSpot("125", VehicleType.CAR));
        parkingLot.addParkingSpots(new ParkingSpot("876", VehicleType.BIKE));
        parkingLot.addParkingSpots(new ParkingSpot("128", VehicleType.BIKE));
        parkingLot.addParkingSpots(new ParkingSpot("127", VehicleType.HEAVY_VEHICLE));
        parkingLot.addParkingSpots(new ParkingSpot("126", VehicleType.HEAVY_VEHICLE));
        parkingLot.addParkingSpots(new ParkingSpot("125", VehicleType.BIKE));

        Ticket t1 = parkingLot.bookParkingSpot(new Vehicle(VehicleType.BIKE));
        Ticket t2 =parkingLot.bookParkingSpot(new Vehicle(VehicleType.BIKE));
        Ticket t3 =parkingLot.bookParkingSpot(new Vehicle(VehicleType.BIKE));
        parkingLot.exit(t1);

        parkingLot.bookParkingSpot(new Vehicle(VehicleType.BIKE));
    }
}
