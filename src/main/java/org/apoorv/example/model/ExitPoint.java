package org.apoorv.example.model;

import org.apoorv.example.enums.PaymentTicketStatus;
import org.apoorv.example.exceptions.ParkingTicketPaidException;
import org.apoorv.example.strategy.IPaymentModeStrategy;

public class ExitPoint {
    public boolean processParkingTicket(ParkingTicket ticket, IPaymentModeStrategy paymentModeStrategy) {
        return ticket.processParkingTicket(paymentModeStrategy);
    }
}
