import java.util.Scanner;

/**
 * IT1170 - Data Structures and Algorithms
 * Practical 2 – Insertion Sort
 * Exercise 2: Count the number of shifts
 */
public class InsertionSortWithShifts {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int totalShifts = 0;

        for (int j = 1; j < n; j++) {
            int key = arr[j];
            int i = j - 1;
            int shifts = 0;

            while (i >= 0 && arr[i] > key) {
                arr[i + 1] = arr[i];
                i--;
                shifts++;
            }
            arr[i + 1] = key;
            totalShifts += shifts;
        }

        System.out.print("Sorted Array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println("\nTotal number of shifts: " + totalShifts);

        scanner.close();
    }
}
