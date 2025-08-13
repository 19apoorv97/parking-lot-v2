package org.apoorv.example.model;

import org.apoorv.example.enums.PaymentTicketStatus;
import org.apoorv.example.exceptions.ParkingTicketPaidException;
import org.apoorv.example.strategy.IPaymentModeStrategy;
import org.springframework.beans.factory.annotation.Autowired;

public class ExitPoint {
    int id;
    String name;

    @Autowired
    ParkingAttendent parkingAttendent;

    ExitPoint(int id,String name){
        this.id = id;
        this.name = name;
    }

    public boolean processParkingTicket(ParkingTicket ticket, IPaymentModeStrategy paymentModeStrategy) {
        return ticket.processParkingTicket(paymentModeStrategy);
    }

    public void payToParkingAttendent(ParkingTicket parkingTicket, IPaymentModeStrategy paymentModeStrategy) {
        parkingAttendent.processParkingTicket(parkingTicket, paymentModeStrategy);
    }
}
