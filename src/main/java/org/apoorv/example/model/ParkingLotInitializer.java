package org.apoorv.example.model;

import org.apoorv.example.enums.ParkingSpotType;

public class ParkingLotInitializer {
    public static ParkingLot initializeParkingLot(String name, int numberOfFloors) {
        ParkingLot parkingLot = new ParkingLot(name);

        // Initialize floors with parking spots
        for (int floorNum = 1; floorNum <= numberOfFloors; floorNum++) {
            ParkingFloor floor = new ParkingFloor(floorNum);
            floor.addCustomerInfoPortal(new CustomerInfoPortal(floorNum, floorNum));

            // Add different types of parking spots
            addParkingSpotsToFloor(floor, floorNum);
            parkingLot.addFloor(floor);
        }

        // Add entry points
        parkingLot.addEntryPoint(new EntryPoint(1, "Main Entrance"));
        parkingLot.addEntryPoint(new EntryPoint(2, "North Entrance"));
        parkingLot.addEntryPoint(new EntryPoint(3, "South Entrance"));

        // Add exit points
        parkingLot.addExitPoint(new ExitPoint(1, "Main Exit")); // with attendant
        parkingLot.addExitPoint(new ExitPoint(2, "North Exit")); // automated
        parkingLot.addExitPoint(new ExitPoint(3, "South Exit")); // automated

        return parkingLot;
    }

    private static void addParkingSpotsToFloor(ParkingFloor floor, int floorNumber) {
        int spotCounter = 1;

        // Motorcycle spots (10 per floor)
        for (int i = 0; i < 10; i++) {
            String spotId = "F" + floorNumber + "-M" + String.format("%02d", spotCounter++);
            floor.addParkingSpot(new ParkingSpot(spotId, ParkingSpotType.TWO_WHEELER, false));
        }

        // Compact spots (20 per floor)
        for (int i = 0; i < 20; i++) {
            String spotId = "F" + floorNumber + "-C" + String.format("%02d", spotCounter++);
            floor.addParkingSpot(new ParkingSpot(spotId, ParkingSpotType.COMPACT, false));
        }

        // Large spots (10 per floor)
        for (int i = 0; i < 10; i++) {
            String spotId = "F" + floorNumber + "-L" + String.format("%02d", spotCounter++);
            floor.addParkingSpot(new ParkingSpot(spotId, ParkingSpotType.LARGE, false));
        }

        // Handicapped spots (5 per floor)
        for (int i = 0; i < 5; i++) {
            String spotId = "F" + floorNumber + "-H" + String.format("%02d", spotCounter++);
            floor.addParkingSpot(new ParkingSpot(spotId, ParkingSpotType.HANDICAPPED, false));
        }

        // Electric spots (5 per floor)
        for (int i = 0; i < 5; i++) {
            String spotId = "F" + floorNumber + "-E" + String.format("%02d", spotCounter++);
            floor.addParkingSpot(new ParkingSpot(spotId, ParkingSpotType.ELECTRIC, true));
        }
    }
}
