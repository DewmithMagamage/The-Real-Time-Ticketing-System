package org.example;

public class Utils {
    public static boolean isValidMenuOption(String input) {
        try {
            int option = Integer.parseInt(input);
            return option >= 1 && option <= 3;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static String colorText(String text, String color) {
        return switch (color.toLowerCase()) {
            case "red" -> "\u001B[31m" + text + "\u001B[0m";
            case "green" -> "\u001B[32m" + text + "\u001B[0m";
            case "yellow" -> "\u001B[33m" + text + "\u001B[0m";
            case "blue" -> "\u001B[34m" + text + "\u001B[0m";
            case "purple" -> "\u001B[35m" + text + "\u001B[0m";
            case "cyan" -> "\u001B[36m" + text + "\u001B[0m";
            default -> text;
        };
    }
}
