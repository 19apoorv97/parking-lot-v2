package org.apoorv.example.model;

import lombok.Getter;
import lombok.Setter;
import org.apoorv.example.enums.ParkingSpotType;

@Getter
@Setter
public class ParkingSpot {
    String id;
    ParkingSpotType type;
    boolean isElectricPanelAvailable;
    boolean isOccupied;

    public ParkingSpot(String id, ParkingSpotType type, boolean isElectricPanelAvailable) {
        this.id = id;
        this.type = type;
        this.isElectricPanelAvailable = isElectricPanelAvailable;
    }
}
