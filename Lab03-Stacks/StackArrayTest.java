import java.util.Scanner;

/**
 * IT1170 - Practical 3
 * Exercise 1: Testing StackArray class
 */
public class StackArrayTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter stack size: ");
        int size = scanner.nextInt();
        StackArray stack = new StackArray(size);

        // Test operations
        stack.push(10);
        stack.push(20);
        stack.push(30);

        stack.display();

        System.out.println("Peek: " + stack.peek());
        System.out.println("Popped: " + stack.pop());

        stack.display();

        System.out.println("Is stack empty? " + stack.isEmpty());
        System.out.println("Is stack full? " + stack.isFull());

        scanner.close();
    }
}
