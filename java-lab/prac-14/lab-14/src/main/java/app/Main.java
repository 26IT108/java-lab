package app;

import service.ItemService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ItemService service = new ItemService();

        try (Scanner scanner = new Scanner(System.in)) {
            boolean running = true;

            while (running) {
                System.out.println("\\n=== Item Manager ===");
                System.out.println("1. Add item");
                System.out.println("2. Show items and count");
                System.out.println("3. Save data");
                System.out.println("4. Load data");
                System.out.println("5. Exit");
                System.out.print("Choose an option: ");

                String choice = scanner.nextLine().trim();

                try {
                    switch (choice) {
                        case "1":
                            System.out.print("Enter item name: ");
                            service.addItem(scanner.nextLine());
                            System.out.println("Item added successfully.");
                            break;
                        case "2":
                            System.out.println("Total items: " + service.getCount());
                            if (service.getItems().isEmpty()) {
                                System.out.println("No items added yet.");
                            } else {
                                for (int i = 0; i < service.getItems().size(); i++) {
                                    System.out.println((i + 1) + ". " + service.getItems().get(i));
                                }
                            }
                            break;
                        case "3":
                            service.saveToFile("items.dat");
                            System.out.println("Data saved to items.dat.");
                            break;
                        case "4":
                            service.loadFromFile("items.dat");
                            System.out.println("Data loaded from items.dat.");
                            break;
                        case "5":
                            running = false;
                            System.out.println("Goodbye!");
                            break;
                        default:
                            System.out.println("Invalid choice. Enter 1 to 5.");
                    }
                } catch (Exception exception) {
                    System.out.println("Operation failed: " + exception.getMessage());
                }
            }
        }
    }
}
