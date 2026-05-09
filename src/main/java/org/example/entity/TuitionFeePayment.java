package org.example.entity;

public class TuitionFeePayment {
    private String studentID;
    private int totalUnits;
    private double discountRate;
    private double totalFee;
    private double amountPaid;

    public TuitionFeePayment(String studentID, int totalUnits, double discountRate) {
        this.studentID = studentID;
        this.totalUnits = totalUnits;
        this.discountRate = discountRate;
        this.totalFee = 0;
        this.amountPaid = 0;
    }

    public String getStudentID() { return studentID; }
    public void setStudentID(String studentID) { this.studentID = studentID; }

    public int getTotalUnits() { return totalUnits; }
    public void setTotalUnits(int totalUnits) { this.totalUnits = totalUnits; }

    public double getDiscountRate() { return discountRate; }
    public void setDiscountRate(double discountRate) { this.discountRate = discountRate; }

    public double getTotalFee() { return totalFee; }
    public void setTotalFee(double totalFee) { this.totalFee = totalFee; }

    public double getAmountPaid() { return amountPaid; }
    public void setAmountPaid(double amountPaid) { this.amountPaid = amountPaid; }

    public double getRemainingBalance() { return totalFee - amountPaid; }

    @Override
    public String toString() {
        return String.format("TuitionFeePayment{studentID='%s', units=%d, totalFee=%.2f, paid=%.2f, balance=%.2f}",
                studentID, totalUnits, totalFee, amountPaid, getRemainingBalance());
    }
}