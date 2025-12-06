package com.assignment.assignment2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class SalesAnalyzer {

    private List<SalesRecord> records;

    public SalesAnalyzer() {
        this.records = new ArrayList<>();
    }

    public void loadData(String filename) throws IOException {
        try (InputStream is = getClass().getClassLoader().getResourceAsStream(filename);
                BufferedReader br = new BufferedReader(new InputStreamReader(is))) {

            if (is == null)
                throw new IOException("File not found: " + filename);

            records = br.lines()
                    .skip(1) // header
                    .map(this::parseLine)
                    .collect(Collectors.toList());
        }
    }

    private SalesRecord parseLine(String line) {
        String[] parts = line.split(",");
        LocalDate date = LocalDate.parse(parts[0]);
        String category = parts[1];
        String product = parts[2];
        int quantity = Integer.parseInt(parts[3]);
        double unitPrice = Double.parseDouble(parts[4]);
        return new SalesRecord(date, category, product, quantity, unitPrice);
    }

    public List<SalesRecord> getRecords() {
        return records;
    }

    // 1. Total Sales by Category
    public Map<String, Double> calculateTotalSalesByCategory() {
        return records.stream()
                .collect(Collectors.groupingBy(
                        SalesRecord::getCategory,
                        Collectors.summingDouble(SalesRecord::getTotalSales)));
    }

    // 2. Average Sales Amount per Order
    public double calculateAverageSales() {
        return records.stream()
                .mapToDouble(SalesRecord::getTotalSales)
                .average()
                .orElse(0.0);
    }

    // 3. Top Performing Product (by quantity sold)
    public Optional<String> getTopPerformingProduct() {
        return records.stream()
                .collect(Collectors.groupingBy(
                        SalesRecord::getProduct,
                        Collectors.summingInt(SalesRecord::getQuantity)))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey);
    }

    // 4. Products sold more than X quantity
    public List<String> getProductsWithQuantityMoreThan(int threshold) {
        return records.stream()
                .filter(r -> r.getQuantity() > threshold)
                .map(SalesRecord::getProduct)
                .distinct()
                .collect(Collectors.toList());
    }
}
