package Problems.SortingComparison;

import java.util.Random;

public class SortingComparison {

    public static void main(String[] args) {
        int[] sizes = { (int) Math.pow(2, 20), (int) Math.pow(2, 22) };
        Random random = new Random();
        
        for (int size : sizes) {
            compareSortingAlgorithms(size, random);
        }
    }

    private static void compareSortingAlgorithms(int size, Random random) {
        // Generate lists for 5-digit numbers
        int[][] fiveDigitLists = new int[3][size];
        for (int i = 0; i < 3; i++) {
            fiveDigitLists[i] = generateArray(size, 5, random);
        }

        // Generate lists for 10-digit numbers
        int[][] tenDigitLists = new int[3][size];
        for (int i = 0; i < 3; i++) {
            tenDigitLists[i] = generateArray(size, 10, random);
        }

        System.out.println("--------------------------------------------------");
        System.out.printf("Testing with array size: %,d\n", size);
        System.out.println("--------------------------------------------------");

        // Test RadixSort1 for both 5-digit and 10-digit numbers
        int[] digitLengths = {5, 10};
        for (int digitLength : digitLengths) {
            for (int r : new int[]{1, 3, 5}) {
                for (int j = 0; j < 3; j++) {
                    int[] copy = (digitLength == 5) ? fiveDigitLists[j].clone() : tenDigitLists[j].clone();
                    long startTime = System.nanoTime();
                    RadixSort1.radixSort(copy, digitLength, r);
                    long endTime = System.nanoTime();
                    long duration = (endTime - startTime) / 1_000_000; // Convert to milliseconds

                    System.out.printf("RadixSort1 (%d-digit, r=%d, List %d) Time: %,d ms\n", digitLength, r, j + 1, duration);
                    System.out.printf("RadixSort1 (%d-digit, r=%d, List %d) isSorted: %b\n", digitLength, r, j + 1, isSorted(copy));
                    System.out.println();
                }
            }
        }

        // Test RadixSort2 for both 5-digit and 10-digit numbers
        for (int digitLength : digitLengths) {
            for (int j = 0; j < 3; j++) {
                int[] copy = (digitLength == 5) ? fiveDigitLists[j].clone() : tenDigitLists[j].clone();
                long startTime = System.nanoTime();
                RadixSort2.radixSort(copy);
                long endTime = System.nanoTime();
                long duration = (endTime - startTime) / 1_000_000; // Convert to milliseconds

                System.out.printf("RadixSort2 (%d-digit, List %d) Time: %,d ms\n", digitLength, j + 1, duration);
                System.out.printf("RadixSort2 (%d-digit, List %d) isSorted: %b\n", digitLength, j + 1, isSorted(copy));
                System.out.println();
            }
        }

        // Test QuickSort with both 5-digit and 10-digit numbers
        for (int digitLength : digitLengths) {
            for (int j = 0; j < 3; j++) {
                int[] copy = (digitLength == 5) ? fiveDigitLists[j].clone() : tenDigitLists[j].clone();
                long startTime = System.nanoTime();
                QuickSort.quickSort(copy, 0, copy.length - 1);
                long endTime = System.nanoTime();
                long duration = (endTime - startTime) / 1_000_000; // Convert to milliseconds

                System.out.printf("QuickSort (%d-digit, List %d) Time: %,d ms\n", digitLength, j + 1, duration);
                System.out.printf("QuickSort (%d-digit, List %d) isSorted: %b\n", digitLength, j + 1, isSorted(copy));
                System.out.println();
            }
        }

        System.out.println("--------------------------------------------------");
    }

    private static int[] generateArray(int size, int maxDigits, Random random) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt((int) Math.pow(10, maxDigits));
        }
        return array;
    }

    private static boolean isSorted(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i - 1] > array[i]) {
                return false;
            }
        }
        return true;
    }
}
