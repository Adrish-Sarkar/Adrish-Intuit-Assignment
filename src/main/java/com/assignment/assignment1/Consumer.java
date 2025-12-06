package com.assignment.assignment1;

public class Consumer implements Runnable {
    private final SharedBuffer buffer;
    private final int itemCount;

    public Consumer(SharedBuffer buffer, int itemCount) {
        this.buffer = buffer;
        this.itemCount = itemCount;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= itemCount; i++) {
                buffer.consume();
                Thread.sleep(1000); // Simulate time taken to consume
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Consumer interrupted");
        }
    }
}
