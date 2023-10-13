import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class GenericQueueMenu {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nQueue Menu:");
            System.out.println("1. Enqueue (Add an element)");
            System.out.println("2. Dequeue (Remove an element)");
            System.out.println("3. Peek (View the front element)");
            System.out.println("4. Display Queue");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter the element to enqueue: ");
                    String element = scanner.nextLine();
                    queue.offer(element);
                    System.out.println(element + " enqueued.");
                    break;
                case 2:
                    if (!queue.isEmpty()) {
                        String dequeuedElement = queue.poll();
                        System.out.println("Dequeued element: " + dequeuedElement);
                    } else {
                        System.out.println("Queue is empty. Cannot dequeue.");
                    }
                    break;
                case 3:
                    if (!queue.isEmpty()) {
                        String frontElement = queue.peek();
                        System.out.println("Front element: " + frontElement);
                    } else {
                        System.out.println("Queue is empty. Nothing to peek.");
                    }
                    break;
                case 4:
                    if (!queue.isEmpty()) {
                        System.out.println("Queue elements: " + queue);
                    } else {
                        System.out.println("Queue is empty.");
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

