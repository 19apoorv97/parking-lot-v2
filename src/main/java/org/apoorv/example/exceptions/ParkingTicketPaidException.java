package org.apoorv.example.exceptions;

public class ParkingTicketPaidException extends RuntimeException {
    public ParkingTicketPaidException(String message) {
        super(message);
    }
}
