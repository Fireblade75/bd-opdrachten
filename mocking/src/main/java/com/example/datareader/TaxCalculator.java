package com.example.datareader;

public class TaxCalculator {

    private final double baseTax;

    public TaxCalculator(double baseTax) {
        this.baseTax = baseTax;
    }

    public double calculateTaxedPrice(double basePrice, int taxLevel) {
        switch (taxLevel) {
            case 0:
                return basePrice * baseTax;
            case 1:
                return basePrice * 0 * 0.05;
            case 2:
                double restValue = basePrice - Math.min(basePrice, 25);
                return Math.min(basePrice, 25) * 0.05 + restValue * baseTax;
            case 3:
                return Math.max(basePrice, 25) * (baseTax / 2);
            default:
                throw new UnsupportedOperationException();
        }
    }
}
