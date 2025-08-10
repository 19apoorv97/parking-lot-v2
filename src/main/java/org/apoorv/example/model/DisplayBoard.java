package org.apoorv.example.model;

import org.apoorv.example.enums.ParkingSpotType;

import java.util.HashMap;
import java.util.Map;

public class DisplayBoard {
    private Map<ParkingSpotType, Integer> availableSpots;

    public void updateAvailability(Map<ParkingSpotType, Integer> availability) {
        this.availableSpots = new HashMap<>(availability);
    }
}
