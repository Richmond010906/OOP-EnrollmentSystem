package org.example.service;

import org.example.entity.TuitionFeePayment;

public interface ITuitionService {
    TuitionFeePayment calculateFee(String studentID, int units, double discount);
    void makePayment(TuitionFeePayment payment, double amount);
    double getRemainingBalance(TuitionFeePayment payment);
}