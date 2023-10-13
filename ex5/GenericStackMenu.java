import java.util.Stack;
import java.util.Scanner;

public class GenericStackMenu {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nStack Menu:");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Display Stack");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter the element to push: ");
                    String element = scanner.nextLine();
                    stack.push(element);
                    System.out.println(element + " pushed onto the stack.");
                    break;
                case 2:
                    if (!stack.isEmpty()) {
                        String poppedElement = stack.pop();
                        System.out.println("Popped element: " + poppedElement);
                    } else {
                        System.out.println("Stack is empty. Cannot pop.");
                    }
                    break;
                case 3:
                    if (!stack.isEmpty()) {
                        String peekedElement = stack.peek();
                        System.out.println("Peeked element: " + peekedElement);
                    } else {
                        System.out.println("Stack is empty. Nothing to peek.");
                    }
                    break;
                case 4:
                    if (!stack.isEmpty()) {
                        System.out.println("Stack elements: " + stack);
                    } else {
                        System.out.println("Stack is empty.");
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

