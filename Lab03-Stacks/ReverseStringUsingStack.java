import java.util.Scanner;

/**
 * IT1170 - Practical 3
 * Exercise 2: Reverse a String using Stack (Character Stack)
 */
public class ReverseStringUsingStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Create stack with capacity equal to string length
        StackArrayChar stack = new StackArrayChar(input.length());

        // Push each character to stack
        for (char ch : input.toCharArray()) {
            stack.push(ch);
        }

        // Build reversed string by popping
        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) {
            reversed.append(stack.pop());
        }

        System.out.println("Reversed string: " + reversed);

        scanner.close();
    }
}

// Separate Character Stack Class (required for Exercise 2)
class StackArrayChar {
    private char[] stack;
    private int top;
    private int capacity;

    public StackArrayChar(int size) {
        capacity = size;
        stack = new char[size];
        top = -1;
    }

    public void push(char item) {
        if (top == capacity - 1) return;
        stack[++top] = item;
    }

    public char pop() {
        if (top == -1) return '\0';
        return stack[top--];
    }

    public boolean isEmpty() {
        return top == -1;
    }
}
