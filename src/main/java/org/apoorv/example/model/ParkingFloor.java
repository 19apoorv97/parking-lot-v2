package org.apoorv.example.model;

import org.apoorv.example.enums.ParkingSpotType;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingFloor {
    int id;
    List<ParkingSpot> parkingSpots;
    DisplayBoard displayBoard;
    CustomerInfoPortal infoPortal;

    ParkingFloor(int id){
        this.id = id;
    }

    public void addParkingSpot(ParkingSpot spot) {
        parkingSpots.add(spot);
        updateDisplayBoard();
    }

    public void addCustomerInfoPortal(CustomerInfoPortal portal) {
        this.infoPortal = portal;
    }

    public int getAvailableSpotsCount(ParkingSpotType type) {
        int count = 0;
        for (ParkingSpot spot : parkingSpots) {
            if (spot.getType() == type && !spot.isOccupied()) {
                count++;
            }
        }
        return count;
    }

    public void updateDisplayBoard() {
        Map<ParkingSpotType, Integer> availableSpots = new HashMap<>();

        for (ParkingSpotType type : ParkingSpotType.values()) {
            int count = 0;
            for (ParkingSpot spot : parkingSpots) {
                if (spot.getType() == type && !spot.isOccupied()) {
                    count++;
                }
            }
            availableSpots.put(type, count);
        }

        displayBoard.updateAvailability(availableSpots);
    }
}
