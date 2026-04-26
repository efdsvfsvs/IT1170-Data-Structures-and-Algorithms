import java.util.Scanner;
import java.util.Arrays;

/**
 * IT1170 - Data Structures and Algorithms
 * Practical 2 – Insertion Sort
 * Exercise 3: Step-by-step Simulation of Insertion Sort
 */
public class StepSimulation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println("\nInitial List: " + Arrays.toString(arr));

        for (int j = 1; j < n; j++) {
            int key = arr[j];
            int i = j - 1;

            while (i >= 0 && arr[i] > key) {
                arr[i + 1] = arr[i];
                i--;
            }
            arr[i + 1] = key;

            System.out.println("Step " + j + " : " + Arrays.toString(arr));
        }

        System.out.println("Sorted List: " + Arrays.toString(arr));

        scanner.close();
    }
}
