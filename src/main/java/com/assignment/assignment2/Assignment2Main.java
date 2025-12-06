package com.assignment.assignment2;

import java.io.IOException;
import java.util.Map;

public class Assignment2Main {
    public static void main(String[] args) {
        SalesAnalyzer analyzer = new SalesAnalyzer();
        try {
            System.out.println("Loading data from sales_data.csv...");
            analyzer.loadData("sales_data.csv");
            
            System.out.println("--- Analysis Results ---");
            
            // 1. Total Sales by Category
            System.out.println("\n1. Total Sales by Category:");
            Map<String, Double> salesByCategory = analyzer.calculateTotalSalesByCategory();
            salesByCategory.forEach((k, v) -> System.out.printf("%s: $%.2f%n", k, v));

            // 2. Average Sales
            System.out.println("\n2. Average Sales Amount per Order:");
            System.out.printf("$%.2f%n", analyzer.calculateAverageSales());

            // 3. Top Performing Product
            System.out.println("\n3. Top Performing Product (by Qty):");
            System.out.println(analyzer.getTopPerformingProduct().orElse("None"));
            
            // 4. High volume products
            System.out.println("\n4. Products with single order quantity > 20:");
            System.out.println(analyzer.getProductsWithQuantityMoreThan(20));

        } catch (IOException e) {
            System.err.println("Error reading data: " + e.getMessage());
        }
    }
}
