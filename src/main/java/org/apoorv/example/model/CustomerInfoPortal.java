package org.apoorv.example.model;

import org.apoorv.example.strategy.IPaymentModeStrategy;

public class CustomerInfoPortal {
    private int id;
    private int floorNumber;

    public CustomerInfoPortal(int floorNumber, int id) {
        this.floorNumber = floorNumber;
        this.id = id;
    }

    public boolean processParkingTicket(ParkingTicket ticket, IPaymentModeStrategy paymentModeStrategy) {
        return ticket.processParkingTicket(paymentModeStrategy);
    }
}
