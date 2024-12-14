package org.example;

public class TicketConsumer implements Runnable {
    private final TicketPool ticketPool;
    private final int retrievalRate;

    public TicketConsumer(TicketPool ticketPool, int retrievalRate) {
        this.ticketPool = ticketPool;
        this.retrievalRate = retrievalRate;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            ticketPool.removeTickets(1); // Simulating one ticket being purchased at a time
            try {
                Thread.sleep(1000 / retrievalRate); // Sleep based on customer purchase speed
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
