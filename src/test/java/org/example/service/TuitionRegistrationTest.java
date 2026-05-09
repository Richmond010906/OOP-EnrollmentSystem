package org.example.entity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TuitionFeeRegistrationTest {

    @Test
    void shouldCalculateRemainingBalanceCorrectly() {
        // 1. Arrange
        TuitionFeePayment payment = new TuitionFeePayment("S1", 5, 0.0);
        payment.setTotalFee(5000);

        // 2. Act
        payment.setAmountPaid(2000);

        // 3. Assert
        assertEquals(3000, payment.getRemainingBalance());
    }
}