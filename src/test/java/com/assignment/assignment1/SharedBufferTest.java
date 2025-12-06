package com.assignment.assignment1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SharedBufferTest {

    @Test
    void testProduceAndConsume() throws InterruptedException {
        SharedBuffer buffer = new SharedBuffer(2);
        buffer.produce(1);
        int item = buffer.consume();
        assertEquals(1, item);
    }

    @Test
    void testBufferLimit() throws InterruptedException {
        SharedBuffer buffer = new SharedBuffer(1);
        buffer.produce(10);

        // Use a separate thread to try to produce another item, it should block
        Thread producerThread = new Thread(() -> {
            try {
                buffer.produce(20);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        producerThread.start();

        // Give it a moment to block
        Thread.sleep(100);
        assertTrue(producerThread.isAlive(), "Producer thread should be waiting because buffer is full");

        // Consume to free space
        buffer.consume();

        // Now producer should finish
        producerThread.join(1000);
        assertFalse(producerThread.isAlive(), "Producer thread should finish after space is available");
    }
}
