package com.fetch.receiptchallenge;

import java.util.ArrayList;
import java.util.List;

public class SampleData {
        public Receipt sampleData() {
        Receipt receipt = new Receipt();
        List<Item> items = new ArrayList<>();

        receipt.setRetailer("Target");
        receipt.setPurchaseDate("2022-01-01");
        receipt.setPurchaseTime("13:01");
        receipt.setTotal("35.35");

        Item dewItem = new Item();
        dewItem.setPrice("6.49");
        dewItem.setShortDescription("Mountain Dew 12PK");
        items.add(dewItem);

        Item pizzaItem = new Item();
        pizzaItem.setPrice("12.25");
        pizzaItem.setShortDescription("Emils Cheese Pizza");
        items.add(pizzaItem);

        Item chickenItem = new Item();
        chickenItem.setPrice("1.26");
        chickenItem.setShortDescription("Knorr Creamy Chicken");
        items.add(chickenItem);

        Item nachoItem = new Item();
        nachoItem.setPrice("3.35");
        nachoItem.setShortDescription("Doritos Nacho Cheese");
        items.add(nachoItem);

        Item klarbrunnItem = new Item();
        klarbrunnItem.setPrice("12.00");
        klarbrunnItem.setShortDescription("   Klarbrunn 12-PK 12 FL OZ  ");
        items.add(klarbrunnItem);
    
        receipt.setItems(items);
    
        return receipt;
    }
}

