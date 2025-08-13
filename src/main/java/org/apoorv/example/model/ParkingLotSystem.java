package org.apoorv.example.model;

import org.springframework.beans.factory.annotation.Autowired;

public class ParkingLotSystem {
    //park Vehicle
    //unPark Vehicle

    @Autowired
    EntryPoint entryPoint;

    public ParkingTicket parkVehicle(Vehicle vehicle) {
        return entryPoint.collectParkingTicket(vehicle);
    }

    public void unparkVehicle() {
        // check if the ticket is paid or not
    }
}