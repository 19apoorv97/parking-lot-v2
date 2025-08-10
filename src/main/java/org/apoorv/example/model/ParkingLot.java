package org.apoorv.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.apoorv.example.enums.ParkingSpotType;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLot {
    String name;
    List<ParkingFloor> floors;
    List<EntryPoint> entryPoints;
    List<ExitPoint> exitPoints;
    private DisplayBoard mainDisplayBoard;

    ParkingLot(String name){
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
}
