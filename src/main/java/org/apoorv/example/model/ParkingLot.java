package org.apoorv.example.model;

import org.apoorv.example.enums.ParkingSpotType;
import org.apoorv.example.enums.VehicleType;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLot {
    String name;
    List<ParkingFloor> floors;
    List<EntryPoint> entryPoints;
    List<ExitPoint> exitPoints;
    private DisplayBoard mainDisplayBoard;

    ParkingLot(String name) {
        this.name = name;
    }

    public void addFloor(ParkingFloor floor) {
        floors.add(floor);
        updateMainDisplayBoard();
    }

    public void addEntryPoint(EntryPoint entryPoint) {
        entryPoints.add(entryPoint);
    }

    public void addExitPoint(ExitPoint exitPoint) {
        exitPoints.add(exitPoint);
    }

    public void updateMainDisplayBoard() {
        Map<ParkingSpotType, Integer> totalAvailable = new HashMap<>();

        for (ParkingSpotType type : ParkingSpotType.values()) {
            int count = 0;
            for (ParkingFloor floor : floors) {
                count += floor.getAvailableSpotsCount(type);
            }
            totalAvailable.put(type, count);
        }

        mainDisplayBoard.updateAvailability(totalAvailable);
    }

    public ParkingSpot findAndSetAvailableParkingSpot(VehicleType vehicleType) {
        // check all floors for vehicle type and if not occupied
        // mark it occupied and return
        // update the display board

        ParkingSpot parkingSpot = null;

        for (ParkingFloor floor : floors) {
            parkingSpot = floor.parkingSpots.stream().filter(
                     spot -> !spot.isOccupied() && spot.getType().name().equals(vehicleType.name()))
                    .findFirst().orElse(null);
            if(parkingSpot!=null) {
                parkingSpot.setOccupied(true);
                floor.updateDisplayBoard();
            }
        }

        return parkingSpot;
    }
}
