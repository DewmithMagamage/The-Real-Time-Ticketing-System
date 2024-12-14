package org.example;

import java.util.Scanner;

public class Config {
    private int totalTickets;
    private int ticketReleaseRate;
    private int customerRetrievalRate;
    private int maxTicketCapacity;

    public Config(int totalTickets, int ticketReleaseRate, int customerRetrievalRate, int maxTicketCapacity) {
        this.totalTickets = totalTickets;
        this.ticketReleaseRate = ticketReleaseRate;
        this.customerRetrievalRate = customerRetrievalRate;
        this.maxTicketCapacity = maxTicketCapacity;
    }

    public int getTotalTickets() {
        return totalTickets;
    }

    public int getTicketReleaseRate() {
        return ticketReleaseRate;
    }

    public int getCustomerRetrievalRate() {
        return customerRetrievalRate;
    }

    public int getMaxTicketCapacity() {
        return maxTicketCapacity;
    }

    public static Config getUserInput() {
        Scanner scanner = new Scanner(System.in);
        int totalTickets = getValidatedInput(scanner, "Enter the total number of tickets available: ", 1, Integer.MAX_VALUE);
        int ticketReleaseRate = getValidatedInput(scanner, "Enter the ticket release rate (vendor speed): ", 1, Integer.MAX_VALUE);
        int customerRetrievalRate = getValidatedInput(scanner, "Enter the customer retrieval rate (purchase speed): ", 1, Integer.MAX_VALUE);
        int maxTicketCapacity = getValidatedInput(scanner, "Enter the max ticket capacity of the pool: ", 1, Integer.MAX_VALUE);

        return new Config(totalTickets, ticketReleaseRate, customerRetrievalRate, maxTicketCapacity);
    }

    private static int getValidatedInput(Scanner scanner, String prompt, int min, int max) {
        int input = 0;
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                input = scanner.nextInt();
                if (input >= min && input <= max) {
                    break;
                } else {
                    System.out.println("⚠️ Input must be between " + min + " and " + max + ".");
                }
            } else {
                System.out.println("⚠️ Please enter a valid number.");
                scanner.next();
            }
        }
        return input;
    }
}
