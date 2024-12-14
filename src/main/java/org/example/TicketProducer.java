package org.example;

public class TicketProducer implements Runnable {
    private final TicketPool ticketPool;
    private final int releaseRate;

    public TicketProducer(TicketPool ticketPool, int releaseRate) {
        this.ticketPool = ticketPool;
        this.releaseRate = releaseRate;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            ticketPool.addTickets(1); // Simulating adding 1 ticket at a time
            try {
                Thread.sleep(1000 / releaseRate); // Sleep based on vendor speed
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
