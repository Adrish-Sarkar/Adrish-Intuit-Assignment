# Overview

This project contains solutions for the two required assignments using Java and Maven.

## Assignments

### Assignment 1: Producer-Consumer Pattern
This section implements a classic Producer-Consumer problem using a custom `SharedBuffer` with thread synchronization (`wait` and `notify`).
*   **Source Code**: `src/main/java/com/assignment/assignment1/`
*   **Key Classes**: `SharedBuffer`, `Producer`, `Consumer`

### Assignment 2: Data Analysis
This section performs an analysis on sales data (CSV format) using Java Streams and Functional Programming.
*   **Source Code**: `src/main/java/com/assignment/assignment2/`
*   **Key Classes**: `SalesAnalyzer`, `SalesRecord`
*   **Data**: `src/main/resources/sales_data.csv`

## Requirements
*   Java 11 or higher
*   Maven 3.6+

## How to Run

### Build the Project
```bash
mvn clean install
```

### Run Assignment 1 (Producer-Consumer)
```bash
mvn exec:java -Dexec.mainClass="com.assignment.assignment1.Assignment1Main"
```
Sample Output:
```
Producer produced: 1
Consumer consumed: 1
Producer produced: 2
Consumer consumed: 2
...
```

### Run Assignment 2 (Data Analysis)
```bash
mvn exec:java -Dexec.mainClass="com.assignment.assignment2.Assignment2Main"
```
Sample Output:
```
Loading data from sales_data.csv...
--- Analysis Results ---

1. Total Sales by Category:
Electronics: $XXXX.XX
Clothing: $XXXX.XX

2. Average Sales Amount per Order:
$XXX.XX

3. Top Performing Product (by Qty):
[Product Name]

4. Products with single order quantity > 20:
[List of Products]
```

## Running Tests
To run the JUnit tests for both assignments:
```bash
mvn test
```
