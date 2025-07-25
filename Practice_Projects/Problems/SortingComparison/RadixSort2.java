package Problems.SortingComparison;

import java.util.Arrays;

public class RadixSort2 {
    
    // Method to perform radix sort
    public static void radixSort(int[] array) {
        int max = getMax(array);
        
        for (int exp = 0; exp < 32; exp += 8) {
            countingSort(array, exp);
        }
    }

    // Method to get the maximum number from the array
    private static int getMax(int[] array) {
        return Arrays.stream(array).max().getAsInt();
    }

    // Counting sort method used by radix sort
    private static void countingSort(int[] array, int exp) {
        int n = array.length;
        int[] output = new int[n];
        int[] count = new int[256];
        
        Arrays.fill(count, 0);

        // Calculate count of elements
        for (int i = 0; i < n; i++) {
            int index = (array[i] >> exp) & 0xFF;
            count[index]++;
        }

        // Calculate cumulative count
        for (int i = 1; i < 256; i++) {
            count[i] += count[i - 1];
        }

        // Place elements in sorted order
        for (int i = n - 1; i >= 0; i--) {
            int index = (array[i] >> exp) & 0xFF;
            output[count[index] - 1] = array[i];
            count[index]--;
        }

        // Copy sorted elements to original array
        System.arraycopy(output, 0, array, 0, n);
    }
}
