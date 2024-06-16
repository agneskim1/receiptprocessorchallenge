package com.fetch.receiptchallenge;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.junit.jupiter.api.Test;

public class PointsCalculatorTest {
    SampleData sampleData = new SampleData();
    Receipt receipt = sampleData.sampleData();

    @Test
    public void testCalculateTotalPoints() {
        
        int points = PointsCalculator.calculateTotalPoints(receipt);

        assertEquals(28, points); // Adjust the expected value based on the rules
    }

    @Test
    public void testAlphaNumbericInRetailersName() {
        String retailer = receipt.getRetailer().replaceAll("[^a-zA-Z0-9]", "");
        int points = retailer.length();

        assertEquals(6, points);
    }

    @Test
    public void testTotalDollarAmountWithNoCents() {
        int points = 0;
        Double total = Double.parseDouble(receipt.getTotal());
        if (total % 1 == 0) {
            points += 50;
        } 
        assertEquals(0, points);
    }

    @Test
    public void testTotalDollarAmountMultipleOf25() {
        int points = 0;
        Double total = Double.parseDouble(receipt.getTotal());

        if (total % .25 == 0) {
            points += 25;
        }

        assertEquals(0, points); 
    }

    @Test
    public void test5PointsForEvery2Items() {
        List<Item> items = receipt.getItems();
        int points = (items.size() / 2 ) * 5;

        assertEquals(10, points);
    }

    @Test
    public void testTrimmedDescriptionMultipleOf3ThenMultiplyAndRoundUp() {
        int points = 0;
        for (Item item : receipt.getItems()) {
            String shortDescription = item.getShortDescription().trim();
            if (shortDescription.length() % 3 == 0 ) {
                Double price = Double.parseDouble(item.getPrice());
                points += Math.ceil(price * 0.2);
            }
        }
        assertEquals(6, points);
    }

    @Test
    public void test6PointsIfDayOfPurchaseDateIsOdd() {
        int points = 0;
        LocalDate purchaseDate = LocalDate.parse(receipt.getPurchaseDate());
        if (purchaseDate.getDayOfMonth() % 2 != 0 ) {
            points += 6;
        }
        assertEquals(6, points); 
    }

    @Test
    public void test10PointsIfPurchaseTimeAfter2AndBefore4() {
        int points = 0;
        LocalTime purchaseTime = LocalTime.parse(receipt.getPurchaseTime());
        if (purchaseTime.isAfter(LocalTime.of(14,0)) && purchaseTime.isBefore(LocalTime.of(16,0))) {
            points += 10;
        }
        assertEquals(0, points); 
    }
}
