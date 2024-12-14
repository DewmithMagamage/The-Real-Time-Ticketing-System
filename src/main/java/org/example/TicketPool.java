package org.example;

import java.util.concurrent.locks.*;

public class TicketPool {
    private final int maxCapacity;
    private int availableTickets;
    private final Lock lock = new ReentrantLock();
    private final Condition notEmpty = lock.newCondition();
    private final Condition notFull = lock.newCondition();

    public TicketPool(int maxCapacity, int initialTickets) {
        this.maxCapacity = maxCapacity;
        this.availableTickets = initialTickets;
    }

    public void addTickets(int count) {
        lock.lock();
        try {
            while (availableTickets + count > maxCapacity) {
                notFull.await();
            }
            availableTickets += count;
            System.out.println(count + " tickets added! Total tickets: " + availableTickets);
            notEmpty.signal();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            lock.unlock();
        }
    }

    public void removeTickets(int count) {
        lock.lock();
        try {
            while (availableTickets < count) {
                notEmpty.await();
            }
            availableTickets -= count;
            System.out.println(count + " tickets purchased! Remaining tickets: " + availableTickets);
            notFull.signal();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            lock.unlock();
        }
    }

    public int getAvailableTickets() {
        return availableTickets;
    }
}
