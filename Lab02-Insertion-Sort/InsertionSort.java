
import java.util.Scanner;

/**
 * IT1170 - Data Structures and Algorithms
 * Practical 2 – Insertion Sort
 * Exercise 1: Insertion Sort in Ascending Order
 */
public class InsertionSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // Insertion Sort - Ascending
        for (int j = 1; j < n; j++) {
            int key = arr[j];
            int i = j - 1;

            while (i >= 0 && arr[i] > key) {
                arr[i + 1] = arr[i];
                i--;
            }
            arr[i + 1] = key;
        }

        // Display sorted array
        System.out.print("Sorted Array (Ascending): ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();

        scanner.close();
    }
}
