package org.example;

public class TicketingSystem {
    private final Config config;
    private final TicketPool ticketPool;
    private Thread producerThread;
    private Thread consumerThread;
    private volatile boolean running;

    public TicketingSystem(Config config) {
        this.config = config;
        this.ticketPool = new TicketPool(config.getMaxTicketCapacity(), config.getTotalTickets());
    }

    public void start() {
        if (running) {
            System.out.println("⚠️ The system is already running.");
            return;
        }
        running = true;
        producerThread = new Thread(new TicketProducer(ticketPool, config.getTicketReleaseRate()));
        consumerThread = new Thread(new TicketConsumer(ticketPool, config.getCustomerRetrievalRate()));
        producerThread.start();
        consumerThread.start();
        System.out.println("🎟️ Ticketing system started...");
    }

    public void stop() {
        if (!running) {
            System.out.println("⚠️ The system is not running.");
            return;
        }
        running = false;
        producerThread.interrupt(); // Interrupt the producer thread
        consumerThread.interrupt(); // Interrupt the consumer thread

        try {
            producerThread.join();
            consumerThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("🛑 Ticketing system stopped.");
    }

    public boolean isRunning() {
        return running;
    }
}
