package com.assignment.assignment1;

import java.util.LinkedList;
import java.util.Queue;

public class SharedBuffer {
    private final Queue<Integer> queue;
    private final int capacity;

    public SharedBuffer(int capacity) {
        this.queue = new LinkedList<>();
        this.capacity = capacity;
    }

    public synchronized void produce(int item) throws InterruptedException {
        while (queue.size() == capacity) {
            System.out.println("Buffer is full. Producer is waiting...");
            wait();
        }
        queue.add(item);
        System.out.println("Producer produced: " + item);
        notifyAll();
    }

    public synchronized int consume() throws InterruptedException {
        while (queue.isEmpty()) {
            System.out.println("Buffer is empty. Consumer is waiting...");
            wait();
        }
        int item = queue.poll();
        System.out.println("Consumer consumed: " + item);
        notifyAll();
        return item;
    }
}
