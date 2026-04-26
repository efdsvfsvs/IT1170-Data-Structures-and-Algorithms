/**
 * IT1170 - Data Structures and Algorithms
 * Practical 3 – Stacks
 * StackArray class - Array implementation of Stack (LIFO)
 */
public class StackArray {
    private int[] stack;
    private int top;
    private int capacity;

    // Constructor
    public StackArray(int size) {
        capacity = size;
        stack = new int[size];
        top = -1;  // Stack is empty initially
    }

    // Push operation
    public void push(int item) {
        if (isFull()) {
            System.out.println("Stack Overflow! Cannot push " + item);
            return;
        }
        stack[++top] = item;
    }

    // Pop operation
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow! Cannot pop.");
            return -1;
        }
        return stack[top--];
    }

    // Peek operation
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return -1;
        }
        return stack[top];
    }

    // Check if stack is empty
    public boolean isEmpty() {
        return top == -1;
    }

    // Check if stack is full
    public boolean isFull() {
        return top == capacity - 1;
    }

    // Display stack elements (from top to bottom)
    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return;
        }
        System.out.print("Stack elements: ");
        for (int i = top; i >= 0; i--) {
            System.out.print(stack[i] + " ");
        }
        System.out.println();
    }
}
