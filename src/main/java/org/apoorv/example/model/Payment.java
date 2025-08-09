package org.apoorv.example.model;

import lombok.AllArgsConstructor;
import org.apoorv.example.strategy.IPaymentModeStrategy;

@AllArgsConstructor
public class Payment {
    IPaymentModeStrategy paymentModeStrategy;
    double amount;

    public boolean processPayment(){
        return paymentModeStrategy.pay(amount);
    }
}
