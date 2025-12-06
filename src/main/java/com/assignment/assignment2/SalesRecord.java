package com.assignment.assignment2;

import java.time.LocalDate;

public class SalesRecord {
    private LocalDate date;
    private String category;
    private String product;
    private int quantity;
    private double unitPrice;

    public SalesRecord(LocalDate date, String category, String product, int quantity, double unitPrice) {
        this.date = date;
        this.category = category;
        this.product = product;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public LocalDate getDate() { return date; }
    public String getCategory() { return category; }
    public String getProduct() { return product; }
    public int getQuantity() { return quantity; }
    public double getUnitPrice() { return unitPrice; }
    
    public double getTotalSales() {
        return quantity * unitPrice;
    }

    @Override
    public String toString() {
        return "SalesRecord{" +
                "date=" + date +
                ", category='" + category + '\'' +
                ", product='" + product + '\'' +
                ", quantity=" + quantity +
                ", unitPrice=" + unitPrice +
                '}';
    }
}
