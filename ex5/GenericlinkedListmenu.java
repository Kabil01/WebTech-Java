import java.util.LinkedList;
import java.util.Scanner;

public class GenericLinkedListMenu {
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nLinked List Menu:");
            System.out.println("1. Add an element to the end");
            System.out.println("2. Add an element to the beginning");
            System.out.println("3. Remove an element");
            System.out.println("4. Display Linked List");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter the element to add to the end: ");
                    String element = scanner.nextLine();
                    linkedList.add(element);
                    System.out.println(element + " added to the end of the linked list.");
                    break;
                case 2:
                    System.out.print("Enter the element to add to the beginning: ");
                    element = scanner.nextLine();
                    linkedList.addFirst(element);
                    System.out.println(element + " added to the beginning of the linked list.");
                    break;
                case 3:
                    if (!linkedList.isEmpty()) {
                        System.out.print("Enter the element to remove: ");
                        element = scanner.nextLine();
                        if (linkedList.remove(element)) {
                            System.out.println(element + " removed from the linked list.");
                        } else {
                            System.out.println(element + " not found in the linked list.");
                        }
                    } else {
                        System.out.println("Linked list is empty. Cannot remove.");
                    }
                    break;
                case 4:
                    if (!linkedList.isEmpty()) {
                        System.out.println("Linked List elements: " + linkedList);
                    } else {
                        System.out.println("Linked list is empty.");
                    }
                    break;
                case 5:
                    System.out.println("Exiting the program.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
                    break;
            }
        }
    }
}

