# SortingComparison

This folder contains implementations and performance comparisons of various sorting algorithms. The focus is on understanding the efficiency and behavior of these algorithms under different conditions.

## Files

### Java Files
- **QuickSort.java**: Implementation of the QuickSort algorithm, which uses a divide-and-conquer approach to sort an array.
- **RadixSort1.java**: Implementation of a Radix Sort algorithm that uses counting sort as a subroutine and supports variable digit lengths and bases.
- **RadixSort2.java**: Another implementation of Radix Sort, optimized for handling 32-bit integers using bitwise operations.
- **SortingComparison.java**: A utility to compare the performance of different sorting algorithms (e.g., RadixSort1 and RadixSort2) on arrays of varying sizes and digit lengths.

### Additional Resources
- **Radix&Quicksort.pdf**: A document providing theoretical insights and comparisons between Radix Sort and QuickSort algorithms.

## Usage

1. **QuickSort**:
   - Call the `quickSort` method with the array, low index, and high index as parameters.
   - Example:
     ```java
     int[] array = {3, 6, 8, 10, 1, 2, 1};
     QuickSort.quickSort(array, 0, array.length - 1);
     ```

2. **RadixSort1**:
   - Use the `radixSort` method with the array, digit length, and base as parameters.
   - Example:
     ```java
     int[] array = {170, 45, 75, 90, 802, 24, 2, 66};
     RadixSort1.radixSort(array, 3, 10);
     ```

3. **RadixSort2**:
   - Use the `radixSort` method with the array as a parameter.
   - Example:
     ```java
     int[] array = {170, 45, 75, 90, 802, 24, 2, 66};
     RadixSort2.radixSort(array);
     ```

4. **SortingComparison**:
   - Run the `SortingComparison` class to benchmark the sorting algorithms on arrays of different sizes and digit lengths.
   - Example:
     ```java
     java SortingComparison
     ```

## Radix Sort Variants

### RadixSort1
- **Description**: RadixSort1 is a variant of Radix Sort where sorting is performed digit by digit, using different radix (base) values. The implementation uses a stable counting sort as a subroutine.
- **Parameters Tested**: Number of digits (5 and 10), radix values (1, 3, 5).

### RadixSort2
- **Description**: RadixSort2 is another variant of Radix Sort that processes digits differently, potentially using more optimized techniques.
- **Parameters Tested**: Number of digits (10 only).
