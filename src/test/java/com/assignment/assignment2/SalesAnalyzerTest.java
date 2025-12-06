package com.assignment.assignment2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

class SalesAnalyzerTest {

    private SalesAnalyzer analyzer;

    @BeforeEach
    void setUp() throws IOException {
        analyzer = new SalesAnalyzer();
        analyzer.loadData("test_sales_data.csv");
    }

    @Test
    void testLoadData() {
        assertNotNull(analyzer.getRecords());
        assertEquals(3, analyzer.getRecords().size());
    }

    @Test
    void testTotalSalesByCategory() {
        Map<String, Double> sales = analyzer.calculateTotalSalesByCategory();
        // Fruit: (10*1.0) + (5*0.5) = 10 + 2.5 = 12.5
        // Vegetable: 20 * 0.2 = 4.0
        assertEquals(12.5, sales.get("Fruit"));
        assertEquals(4.0, sales.get("Vegetable"));
    }

    @Test
    void testAverageSales() {
        // Total sales = 12.5 + 4.0 = 16.5
        // Count = 3
        // Avg = 5.5
        assertEquals(5.5, analyzer.calculateAverageSales());
    }

    @Test
    void testTopPerformingProduct() {
        // Apple: 10, Banana: 5, Carrot: 20
        Optional<String> top = analyzer.getTopPerformingProduct();
        assertTrue(top.isPresent());
        assertEquals("Carrot", top.get());
    }
    
    @Test
    void testProductsWithQuantityMoreThan() {
        List<String> products = analyzer.getProductsWithQuantityMoreThan(8);
        assertTrue(products.contains("Apple"));
        assertTrue(products.contains("Carrot"));
        assertFalse(products.contains("Banana"));
    }
}
