package org.example.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TuitionFeePaymentTest {

    private TuitionFeePayment tuitionFeePayment;

    @BeforeEach
    void setup(){
        tuitionFeePayment = new TuitionFeePayment();
    }

    @Test
    @DisplayName("Calculator Tuition Fee")
    void shouldCalculateCorrectTuitionFeeWithNoDiscount(){
        //Assert
        assertEquals(5000, tuitionFeePayment.calculateTuitionFee(5,0));
    }

    @Test
    void shouldCalculateCorrectTuitionFeeWithDiscount(){
        //Assert
        assertEquals(4500, tuitionFeePayment.calculateTuitionFee(5, 0.10));
    }

    @Test
    void shouldMakePaymentWorth500(){
        tuitionFeePayment.calculateTuitionFee(5, 0);
        tuitionFeePayment.makePayment(500);
        //Assert
        assertEquals(4500, tuitionFeePayment.getBalance());
    }

    @Test
    void shouldCheckFullyPaid(){
        tuitionFeePayment.calculateTuitionFee(5, 0);
        tuitionFeePayment.makePayment(5000);
        //Assert
        assertTrue(tuitionFeePayment.isFullyPaid());
    }

    @Test
    void shouldCheckNotFullyPaid(){
        tuitionFeePayment.calculateTuitionFee(5,0);
        tuitionFeePayment.makePayment(4700);
        //Assert
        assertFalse(tuitionFeePayment.isFullyPaid());
    }
}