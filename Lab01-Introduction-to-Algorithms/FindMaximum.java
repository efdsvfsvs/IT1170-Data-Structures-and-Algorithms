import java.util.Scanner;

/**
 * IT1170 - Data Structures and Algorithms
 * Practical 1 – Introduction to Algorithms
 * Exercise 3: Java Program to find maximum of three numbers
 */
public class FindMaximum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get input from user
        System.out.print("Enter first number: ");
        int a = scanner.nextInt();

        System.out.print("Enter second number: ");
        int b = scanner.nextInt();

        System.out.print("Enter third number: ");
        int c = scanner.nextInt();

        // Find maximum
        int max;
        if (a >= b && a >= c) {
            max = a;
        } else if (b >= a && b >= c) {
            max = b;
        } else {
            max = c;
        }

        // Display result
        System.out.println("Maximum number is: " + max);

        scanner.close();
    }
}
