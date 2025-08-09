package org.apoorv.example.model;

import org.apoorv.example.strategy.IPaymentModeStrategy;

public class CustomerInfoPanel {
    public boolean processParkingTicket(ParkingTicket ticket, IPaymentModeStrategy paymentModeStrategy) {
        return ticket.processParkingTicket(paymentModeStrategy);
    }
}
