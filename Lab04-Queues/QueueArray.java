/**
 * IT1170 - Data Structures and Algorithms
 * Practical 4 – Queues
 * Linear Queue using Array
 */
public class QueueArray {
    private int[] queue;
    private int front;
    private int rear;
    private int capacity;

    // Constructor
    public QueueArray(int size) {
        capacity = size;
        queue = new int[size];
        front = 0;
        rear = -1;   // Empty queue
    }

    // Insert (Enqueue) - Add element at rear
    public void insert(int item) {
        if (isFull()) {
            System.out.println("Queue is full! Cannot insert " + item);
            return;
        }
        queue[++rear] = item;
    }

    // Remove (Dequeue) - Remove element from front
    public int remove() {
        if (isEmpty()) {
            System.out.println("Queue is empty! Cannot remove.");
            return -1;
        }
        int item = queue[front];
        front++;
        return item;
    }

    // Peek Front - View front element without removing
    public int peekFront() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return -1;
        }
        return queue[front];
    }

    // Check if queue is empty
    public boolean isEmpty() {
        return front > rear;
    }

    // Check if queue is full
    public boolean isFull() {
        return rear == capacity - 1;
    }

    // Get current number of elements in queue
    public int getCount() {
        if (isEmpty()) return 0;
        return rear - front + 1;
    }

    // Display queue elements from front to rear
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return;
        }
        System.out.print("Queue elements: ");
        for (int i = front; i <= rear; i++) {
            System.out.print(queue[i] + " ");
        }
        System.out.println();
    }
}
