import java.util.Scanner;

/**
 * IT1170 - Practical 4
 * Exercise 2: Testing Circular Queue
 */
public class CircularQueueTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the circular queue: ");
        int size = scanner.nextInt();
        CircularQueue cq = new CircularQueue(size);

        // Insert initial elements until full
        for (int i = 0; i < size; i++) {
            System.out.print("Enter element to insert: ");
            int val = scanner.nextInt();
            cq.insert(val);
        }

        // Try to insert one more (should show full)
        System.out.print("Enter new element to insert: ");
        int extra = scanner.nextInt();
        cq.insert(extra);

        // Remove one element
        System.out.println("Removing: " + cq.remove());

        // Insert again
        System.out.print("Enter new element to insert: ");
        int val1 = scanner.nextInt();
        cq.insert(val1);

        System.out.print("Enter another element to insert: ");
        int val2 = scanner.nextInt();
        cq.insert(val2);

        cq.display();
        System.out.println("Queue Count: " + cq.getCount());

        scanner.close();
    }
}
