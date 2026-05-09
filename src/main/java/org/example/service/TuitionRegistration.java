package org.example.service;

import org.example.entity.TuitionFeePayment;

public class TuitionRegistration implements ITuitionService{
    private static final double PRICE_PER_UNIT = 1000.0;


    @Override
    public TuitionFeePayment calculateFee(String studentID, int units, double discount) {
        TuitionFeePayment payment = new TuitionFeePayment(studentID, units, discount);
        double ratePerUnit = 1000.0;
        double total = (units * ratePerUnit) * (1 - discount);
        payment.setTotalFee(total);
        return payment;
    }

    @Override
    public void makePayment(TuitionFeePayment payment, double amount) {
        payment.setAmountPaid(payment.getAmountPaid() + amount);
    }

    @Override
    public double getRemainingBalance(TuitionFeePayment payment) {
        return 0;
    }
}
