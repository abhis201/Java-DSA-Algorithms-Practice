package Problems;

import java.util.Arrays;
import java.util.Random;

public class SortingAlgorithmsPerformance {

    // Insertion Sort implementation
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    // Merge Sort implementation
    public static void mergeSort(int[] arr) {
        if (arr.length < 2) {
            return;
        }
        int mid = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);

        mergeSort(left);
        mergeSort(right);
        merge(arr, left, right);
    }

    // Merge helper function for merge sort
    public static void merge(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }
        while (i < left.length) {
            arr[k++] = left[i++];
        }
        while (j < right.length) {
            arr[k++] = right[j++];
        }
    }

    // Modified Merge Sort using Insertion Sort for small arrays
    public static void modifiedMergeSort(int[] arr, int k) {
        if (arr.length <= k) {
            insertionSort(arr);
            return;
        }
        int mid = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);

        modifiedMergeSort(left, k);
        modifiedMergeSort(right, k);
        merge(arr, left, right);
    }

    // Generate an already sorted array
    public static int[] generateAlreadySortedArray(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }
        return arr;
    }

    // Generate a reversely sorted array
    public static int[] generateReverselySortedArray(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = n - i;
        }
        return arr;
    }

    // Generate a random permutation of array
    public static void randomPermute(int[] arr) {
        Random rand = new Random();
        for (int i = 0; i < arr.length - 1; i++) {
            int j = i + rand.nextInt(arr.length - i);
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    // Measure the running time of a sorting algorithm
    public static long measureTime(int[] arr, String algorithm, int k) {
        long startTime = System.nanoTime();
        if (algorithm.equals("insertion")) {
            insertionSort(arr);
        } else if (algorithm.equals("merge")) {
            mergeSort(arr);
        } else if (algorithm.equals("modifiedMerge")) {
            modifiedMergeSort(arr, k);
        }
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    // Measure initialization time
    public static long measureInitializationTime(int n, String type) {
        long startTime = System.nanoTime();
        if (type.equals("sorted")) {
            generateAlreadySortedArray(n);
        } else if (type.equals("reversed")) {
            generateReverselySortedArray(n);
        } else if (type.equals("random")) {
            int[] arr = generateAlreadySortedArray(n);
            randomPermute(arr);
        }
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    public static void main(String[] args) {
        int[] sizes = { 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096 };
        int[] largeSizes = { 1048576, 4194304 }; // 2^20 and 2^22
        int[] kValues = { 1, 4, 8, 32, 64, 128, 256, 512, 1024, 2048, 4096 };

        System.out.println("Initialization Time (ns):");
        System.out.println("n\tSorted\tReversed\tRandom");

        for (int n : sizes) {
            // Measure initialization time
            long initSortedTime = measureInitializationTime(n, "sorted");
            long initReversedTime = measureInitializationTime(n, "reversed");
            long initRandomTime = measureInitializationTime(n, "random");

            System.out.printf("%d\t%d\t%d\t%d%n", n, initSortedTime, initReversedTime, initRandomTime);
        }

        System.out.println("\nAlgorithm Execution Time (ns):");
        System.out.println(
                "n\tSorted (Insertion)\tReversed (Insertion)\tRandom (Insertion)\tSorted (Merge)\tReversed (Merge)\tRandom (Merge)");

        for (int n : sizes) {
            // Insertion Sort
            int[] sortedArray = generateAlreadySortedArray(n);
            long insertionSortedTime = measureTime(Arrays.copyOf(sortedArray, sortedArray.length), "insertion", 0);

            int[] reversedArray = generateReverselySortedArray(n);
            long insertionReversedTime = measureTime(Arrays.copyOf(reversedArray, reversedArray.length), "insertion",
                    0);

            long insertionRandomTimeSum = 0;
            int permutations = 3;
            for (int i = 0; i < permutations; i++) {
                int[] randomArray = generateAlreadySortedArray(n); // Start with sorted array
                randomPermute(randomArray); // Randomly permute the array
                insertionRandomTimeSum += measureTime(Arrays.copyOf(randomArray, randomArray.length), "insertion", 0);
            }
            long insertionRandomTime = insertionRandomTimeSum / permutations;

            // Merge Sort
            long mergeSortedTime = measureTime(Arrays.copyOf(sortedArray, sortedArray.length), "merge", 0);
            long mergeReversedTime = measureTime(Arrays.copyOf(reversedArray, reversedArray.length), "merge", 0);

            long mergeRandomTimeSum = 0;
            for (int i = 0; i < permutations; i++) {
                int[] randomArray = generateAlreadySortedArray(n); // Start with sorted array
                randomPermute(randomArray); // Randomly permute the array
                mergeRandomTimeSum += measureTime(Arrays.copyOf(randomArray, randomArray.length), "merge", 0);
            }
            long mergeRandomTime = mergeRandomTimeSum / permutations;

            System.out.printf("%d\t%d\t%d\t%d\t%d\t%d\t%d%n", n, insertionSortedTime, insertionReversedTime,
                    insertionRandomTime, mergeSortedTime, mergeReversedTime, mergeRandomTime);
        }

        System.out.println("\nModified Merge Sort Initialization Time (ns):");
        System.out.println("n\tk\tSorted\tReversed\tRandom");

        for (int n : largeSizes) {
            for (int k : kValues) {
                // Measure initialization time
                long initSortedTime = measureInitializationTime(n, "sorted");
                long initReversedTime = measureInitializationTime(n, "reversed");
                long initRandomTime = measureInitializationTime(n, "random");

                System.out.printf("%d\t%d\t%d\t%d\t%d%n", n, k, initSortedTime, initReversedTime, initRandomTime);
            }
        }

        System.out.println("\nModified Merge Sort Execution Time (ns):");
        System.out.println("n\tk\tSorted\tReversed\tRandom");

        for (int n : largeSizes) {
            for (int k : kValues) {
                // Modified Merge Sort
                int[] sortedArray = generateAlreadySortedArray(n);
                long modifiedSortedTime = measureTime(Arrays.copyOf(sortedArray, sortedArray.length), "modifiedMerge",
                        k);

                int[] reversedArray = generateReverselySortedArray(n);
                long modifiedReversedTime = measureTime(Arrays.copyOf(reversedArray, reversedArray.length),
                        "modifiedMerge", k);

                long modifiedRandomTimeSum = 0;
                int permutations = 3;
                for (int i = 0; i < permutations; i++) {
                    int[] randomArray = generateAlreadySortedArray(n); // Start with sorted array
                    randomPermute(randomArray); // Randomly permute the array
                    modifiedRandomTimeSum += measureTime(Arrays.copyOf(randomArray, randomArray.length),
                            "modifiedMerge", k);
                }
                long modifiedRandomTime = modifiedRandomTimeSum / permutations;

                System.out.printf("%d\t%d\t%d\t%d\t%d%n", n, k, modifiedSortedTime, modifiedReversedTime,
                        modifiedRandomTime);
            }
        }
    }
}