package org.apoorv.example.strategy.impl;

import org.apoorv.example.strategy.IPaymentModeStrategy;

public class CashPaymentModeStrategy implements IPaymentModeStrategy {
    @Override
    public boolean pay(double amount) {
        return false;
    }
}
