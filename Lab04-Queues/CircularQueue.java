/**
 * IT1170 - Data Structures and Algorithms
 * Practical 4 – Queues
 * Circular Queue using Array
 */
public class CircularQueue {
    private int[] queue;
    private int front;
    private int rear;
    private int capacity;
    private int count;   // To keep track of number of elements

    // Constructor
    public CircularQueue(int size) {
        capacity = size;
        queue = new int[size];
        front = 0;
        rear = -1;
        count = 0;
    }

    // Insert (Enqueue) - Circular behavior
    public void insert(int item) {
        if (isFull()) {
            System.out.println("Queue is full! Cannot insert " + item);
            return;
        }
        rear = (rear + 1) % capacity;
        queue[rear] = item;
        count++;
    }

    // Remove (Dequeue)
    public int remove() {
        if (isEmpty()) {
            System.out.println("Queue is empty! Cannot remove.");
            return -1;
        }
        int item = queue[front];
        front = (front + 1) % capacity;
        count--;
        return item;
    }

    // Peek Front
    public int peekFront() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return -1;
        }
        return queue[front];
    }

    // Check if empty
    public boolean isEmpty() {
        return count == 0;
    }

    // Check if full
    public boolean isFull() {
        return count == capacity;
    }

    // Get current count
    public int getCount() {
        return count;
    }

    // Display queue (from front to rear - circular)
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return;
        }
        System.out.print("Queue elements: ");
        int i = front;
        for (int c = 0; c < count; c++) {
            System.out.print(queue[i] + " ");
            i = (i + 1) % capacity;
        }
        System.out.println();
    }
}
