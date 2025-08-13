package org.apoorv.example.model;

import org.springframework.beans.factory.annotation.Autowired;

public class EntryPoint {
    @Autowired
    ParkingLot parkingLot;

    private int id;
    private String name;

    EntryPoint(int id,String name){
        this.id = id;
        this.name = name;
    }

    public ParkingTicket collectParkingTicket(Vehicle vehicle){
        // find the parking spot
        ParkingSpot parkingSpot = parkingLot.findAndSetAvailableParkingSpot(vehicle.getVehicleType());

        if(parkingSpot==null){
            System.out.println("No parking spot found");
            return null;
        }

        return new ParkingTicket(vehicle,parkingSpot);
    }
}
