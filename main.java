import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("=== Temperature Converter ===");

        while (running) {
            System.out.println("\nChoose the input scale:");
            System.out.println("1. Celsius");
            System.out.println("2. Fahrenheit");
            System.out.println("3. Kelvin");
            System.out.println("4. Exit");
            System.out.print("Enter your choice (1-4): ");

            int choice = getValidIntegerInput(scanner);

            if (choice == 4) {
                running = false;
                System.out.println("Thank you for using the Temperature Converter! Goodbye.");
                break;
            }

            if (choice < 1 || choice > 4) {
                System.out.println("Invalid choice! Please select a number between 1 and 4.");
                continue;
            }

            System.out.print("Enter the temperature value to convert: ");
            double temperature = getValidDoubleInput(scanner);

            // Perform conversions based on user choice
            switch (choice) {
                case 1: // Celsius
                    convertCelsius(temperature);
                    break;
                case 2: // Fahrenheit
                    convertFahrenheit(temperature);
                    break;
                case 3: // Kelvin
                    convertKelvin(temperature);
                    break;
            }
        }
        scanner.close();
    }

    // Helper method to handle invalid choices (like typing characters instead of numbers)
    private static int getValidIntegerInput(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input! Please enter a valid number.");
            scanner.next(); // Clear the invalid input
            System.out.print("Enter your choice (1-4): ");
        }
        return scanner.nextInt();
    }

    // Helper method to handle invalid temperature values
    private static double getValidDoubleInput(Scanner scanner) {
        while (!scanner.hasNextDouble()) {
            System.out.println("Invalid input! Please enter a valid decimal or numeric value.");
            scanner.next(); // Clear the invalid input
            System.out.print("Enter the temperature value: ");
        }
        return scanner.nextDouble();
    }

    // Conversion Logic Functions
    private static void convertCelsius(double c) {
        double f = (c * 9 / 5) + 32;
        double k = c + 273.15;
        System.out.printf("\nResults:\n");
        System.out.printf("%.2f °C = %.2f °F\n", c, f);
        System.out.printf("%.2f °C = %.2f K\n", c, k);
    }

    private static void convertFahrenheit(double f) {
        double c = (f - 32) * 5 / 9;
        double k = c + 273.15;
        System.out.printf("\nResults:\n");
        System.out.printf("%.2f °F = %.2f °C\n", f, c);
        System.out.printf("%.2f °F = %.2f K\n", f, k);
    }

    private static void convertKelvin(double k) {
        if (k < 0) {
            System.out.println("Warning: Kelvin cannot be below Absolute Zero (0 K), but calculating anyway.");
        }
        double c = k - 273.15;
        double f = (c * 9 / 5) + 32;
        System.out.printf("\nResults:\n");
        System.out.printf("%.2f K = %.2f °C\n", k, c);
        System.out.printf("%.2f K = %.2f °F\n", k, f);
    }
}
