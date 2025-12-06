package com.assignment.assignment1;

public class Producer implements Runnable {
    private final SharedBuffer buffer;
    private final int itemCount;

    public Producer(SharedBuffer buffer, int itemCount) {
        this.buffer = buffer;
        this.itemCount = itemCount;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= itemCount; i++) {
                buffer.produce(i);
                Thread.sleep(500); // Simulate time taken to produce
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Producer interrupted");
        }
    }
}
