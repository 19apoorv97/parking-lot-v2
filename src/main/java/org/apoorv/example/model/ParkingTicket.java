package org.apoorv.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.apoorv.example.enums.PaymentTicketStatus;
import org.apoorv.example.exceptions.ParkingTicketPaidException;
import org.apoorv.example.strategy.IPaymentModeStrategy;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class ParkingTicket {
    PaymentTicketStatus ticketStatus;
    LocalDateTime entryTime;
    LocalDateTime exitTime;

    public boolean processParkingTicket(IPaymentModeStrategy paymentModeStrategy){
        if(ticketStatus == PaymentTicketStatus.UNPAID) {
            double amount = this.calculatePaymentTicketCharges();
            Payment payment = new Payment(paymentModeStrategy, amount);
            return payment.processPayment();
        }
        else
            throw new ParkingTicketPaidException("PARKING TICKET ALREADY PAID");
    }

    private double calculatePaymentTicketCharges() {
        long hours = this.getParkingDurationInHours();
        if (hours < 1) hours = 1; // Minimum 1 hour charge

        double fee = 0.0;
        if (hours == 1) {
            fee = 4.0; // $4 for first hour
        } else if (hours <= 3) {
            fee = 4.0 + (hours - 1) * 3.5; // $3.5 for 2nd and 3rd hours
        } else {
            fee = 4.0 + 2 * 3.5 + (hours - 3) * 2.5; // $2.5 for remaining hours
        }

        return fee;
    }

    private long getParkingDurationInHours() {
        LocalDateTime endTime = exitTime != null ? exitTime : LocalDateTime.now();
        return java.time.Duration.between(entryTime, endTime).toHours();
    }
}
