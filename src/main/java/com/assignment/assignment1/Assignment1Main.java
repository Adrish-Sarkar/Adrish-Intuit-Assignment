package com.assignment.assignment1;

public class Assignment1Main {
    public static void main(String[] args) {
        SharedBuffer buffer = new SharedBuffer(5); // Buffer capacity of 5
        int totalItems = 10; // Number of items to produce/consume

        Thread producerThread = new Thread(new Producer(buffer, totalItems), "Producer");
        Thread consumerThread = new Thread(new Consumer(buffer, totalItems), "Consumer");

        producerThread.start();
        consumerThread.start();

        try {
            producerThread.join();
            consumerThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("Assignment 1: Producer-Consumer Demo Completed.");
    }
}
