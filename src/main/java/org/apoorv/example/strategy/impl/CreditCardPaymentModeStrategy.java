package org.apoorv.example.strategy.impl;

import org.apoorv.example.strategy.IPaymentModeStrategy;

public class CreditCardPaymentModeStrategy implements IPaymentModeStrategy {
    @Override
    public boolean pay(double amount) {
        return true;
    }
}
