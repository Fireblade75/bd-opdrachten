package com.example.datareader;

import org.assertj.core.data.Offset;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;


class TaxCalculatorTest {

    private Offset<Double> offset = Offset.offset(0.01);

    @Test
    void testBaseTax() {
        TaxCalculator doubleCalculator = new TaxCalculator(2);
        double basePrice = 10;
        double doubleTaxedPrice = doubleCalculator.calculateTaxedPrice(10, 0);
        assertThat(2 * basePrice).isEqualTo(doubleTaxedPrice, offset);

        TaxCalculator tripleCalculator = new TaxCalculator(3);
        double tripleTaxedPrice = tripleCalculator.calculateTaxedPrice(10, 0);
        assertThat(3 * basePrice).isEqualTo(tripleTaxedPrice, offset);
    }

    @Test
    void testBadTaxLevel() {
        TaxCalculator doubleCalculator = new TaxCalculator(2);
        assertThatCode(() -> {
            doubleCalculator.calculateTaxedPrice(10, 8);
        }).isInstanceOf(UnsupportedOperationException.class);
    }
}