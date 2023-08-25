package ru.job4j.queue;

import java.util.Queue;

public class AppleStore {
    private final Queue<Customer> queue;

    private final int count;

    public AppleStore(Queue<Customer> queue, int count) {
        this.queue = queue;
        this.count = count;
    }

    public String getLastHappyCustomer() {
        String lastHappyCustomer = null;
        for (int i = 0; i < count; i++) {
            String currentCustomer = queue.poll().name();
            if (currentCustomer == null) {
                break;
            }
            lastHappyCustomer = currentCustomer;
        }
        return lastHappyCustomer;
    }

    public String getFirstUpsetCustomer() {
        String lastHappyCustomer = null;
        for (int i = 0; i < count; i++) {
            if (queue.poll().name() == null) {
                break;
            }
        }
        return queue.poll().name();
    }
}