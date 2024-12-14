package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get the configuration values from the user
        Config config = Config.getUserInput();
        TicketingSystem ticketingSystem = new TicketingSystem(config);

        while (true) {
            //menu options
            System.out.println("***********************************************");
            System.out.println("🎟️  Welcome to Real-Time Ticketing System  🎟️");
            System.out.println("***********************************************");
            System.out.println("📜 MENU OPTIONS:");
            System.out.println("1. Start the ticketing system");
            System.out.println("2. Stop the ticketing system");
            System.out.println("3. Exit");
            System.out.print("🔢 Choose an option (1-3): ");

            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    ticketingSystem.start();  // Start the system
                    break;
                case 2:
                    ticketingSystem.stop();  // Stop the system
                    break;
                case 3:
                    System.out.println("👋 Exiting the system...");
                    scanner.close();
                    return;
                default:
                    System.out.println("⚠️ Invalid option. Please try again.");
            }
        }
    }
}

