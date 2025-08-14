package org.apoorv.example.model;

import org.apoorv.example.strategy.IPaymentModeStrategy;
import org.springframework.beans.factory.annotation.Autowired;

public class ParkingLotSystem {
    //park Vehicle
    //unPark Vehicle

    @Autowired
    EntryPoint entryPoint;

    @Autowired
    ExitPoint exitPoint;

    public ParkingTicket parkVehicle(Vehicle vehicle) {
        return entryPoint.collectParkingTicket(vehicle);
    }

    public void unparkVehicle(Vehicle vehicle, ParkingTicket ticket, IPaymentModeStrategy paymentModeStrategy) {
        // check if ticket is paid or not
        // free the parking spot
        // update display board
        exitPoint.processExit(vehicle,ticket,paymentModeStrategy);
    }
}