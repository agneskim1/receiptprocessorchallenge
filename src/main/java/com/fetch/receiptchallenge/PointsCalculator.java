package com.fetch.receiptchallenge;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class PointsCalculator {
    public static Integer calculateTotalPoints(Receipt receipt) {
    int totalPoints = 0;
    
    // // One point for every alphanumeric character in the retailer name.
    String retailer = receipt.getRetailer().replaceAll("[^a-zA-Z0-9]", "");
    totalPoints += retailer.length();
    

    // 50 points if the total is a round dollar amount with no cents.
    Double total = Double.parseDouble(receipt.getTotal());
    if (total % 1 == 0) {
        totalPoints += 50;
    }

    // 25 points if the total is a multiple of 0.25.
    if (total % .25 == 0) {
        totalPoints += 25;
    }

    // 5 points for every two items on the receipt.
    List<Item> items = receipt.getItems();
    totalPoints += Math.floor(items.size() / 2 ) * 5;

    // If the trimmed length of the item description is a multiple of 3, multiply the price by 0.2 and round up to the nearest integer. The result is the number of points earned.
    for (Item item : receipt.getItems()) {
        String shortDescription = item.getShortDescription().trim();
        if (shortDescription.length() % 3 == 0 ) {
            Double price = Double.parseDouble(item.getPrice());
            totalPoints += Math.ceil(price * 0.2);
        }
    }
    // 6 points if the day in the purchase date is odd.
    LocalDate purchaseDate = LocalDate.parse(receipt.getPurchaseDate());
    if (purchaseDate.getDayOfMonth() % 2 != 0 ) {
        totalPoints += 6;
    }
    
    // 10 points if the time of purchase is after 2:00pm and before 4:00pm.
    LocalTime purchaseTime = LocalTime.parse(receipt.getPurchaseTime());
    if (purchaseTime.isAfter(LocalTime.of(14,0)) && purchaseTime.isBefore(LocalTime.of(16,0))) {
        totalPoints += 10;
    }

    return totalPoints;

    }
}
