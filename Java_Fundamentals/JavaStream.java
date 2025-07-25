/**
 * The Java Stream API, introduced in Java 8, provides a powerful and functional approach to processing collections of objects.
 * It enables efficient data manipulation through a pipeline of operations.
 *
 * Core Concepts:
 * 1. Stream Source:
 *    - Streams originate from various sources, such as collections (using stream() or parallelStream()),
 *      arrays (Arrays.stream()), or I/O channels (Files.lines()).
 *      - `stream()` and `parallelStream()`: These methods are available on Java collections. The `stream()` method creates a sequential stream, 
 *          while `parallelStream()` creates a parallel stream that can process elements concurrently, leveraging multiple CPU cores for better performance in large datasets.
 *      - `Arrays.stream()`: This method is used to create a stream from an array. It provides a convenient way to process array elements using the Stream API.
 *      - `Files.lines()`: This method is used to create a stream of lines from a file. It is particularly useful for reading and processing large text files line by line without loading the entire file into memory.
 *
 * 2. Intermediate Operations:
 *    - These operations transform a stream into another stream, allowing for chaining multiple operations to form a pipeline.
 *      Examples include:
 *        - filter(): Selects elements based on a given predicate.
 *        - map(): Transforms each element into a new element.
 *        - sorted(): Sorts elements based on a comparator.
 *        - distinct(): Removes duplicate elements.
 *        - skip(): Skips a specified number of elements.
 *        - limit(): Limits the stream to a specified number of elements.
 *
 * 3. Terminal Operations:
 *    - These operations produce a non-stream result, marking the end of the stream pipeline.
 *      Examples include:
 *        - forEach(): Performs an action on each element.
 *        - collect(): Gathers elements into a collection (e.g., List, Set, Map).
 *        - count(): Returns the number of elements in the stream.
 *        - min(), max(): Returns the minimum or maximum element.
 *        - reduce(): Combines elements into a single result.
 *        - anyMatch(), allMatch(), noneMatch(): Checks if elements match a given predicate.
 *
 * How Streams Work:
 * - Declarative Style:
 *   Streams promote a declarative style of programming, focusing on what to do with data rather than how to do it (e.g., explicit loops).
 * - Lazy Execution:
 *   Intermediate operations are executed lazily, meaning they are only processed when a terminal operation is invoked.
 * - Immutability:
 *   Streams do not modify the original data source; they operate on a sequence of elements and produce new results.
 *
 * Functional Interfaces and Lambdas:
 * - Stream operations often accept functional interfaces (like Predicate, Function, Consumer) as parameters,
 *   commonly implemented using lambda expressions for concise code.
 */
import java.util.*;
import java.util.stream.*;

public class JavaStream {

    public static void main(String[] args) {
        // Example 1: Filtering and Mapping with Streams
        List<String> names = Arrays.asList("John", "Jane", "Jack", "Jill", "James");
        List<String> filteredNames = names.stream()
                .filter(name -> name.startsWith("J"))
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println("Filtered and Mapped Names: " + filteredNames);

        // Example 2: Using Optional with Streams
        List<String> items = Arrays.asList("Apple", "Banana", "Cherry", null, "Date");
        items.stream()
                .filter(Objects::nonNull)
                .forEach(item -> System.out.println("Item: " + item));

        // Example 3: Grouping and Counting
        List<String> words = Arrays.asList("apple", "banana", "apple", "orange", "banana", "apple");
        Map<String, Long> wordCount = words.stream()
                .collect(Collectors.groupingBy(word -> word, Collectors.counting()));
        System.out.println("Word Count: " + wordCount);

        // Example 4: Using Lambdas with Streams
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        int sum = numbers.stream()
                .reduce(0, (a, b) -> a + b);
        System.out.println("Sum of Numbers: " + sum);

        // Example 5: Nullable Streams
        Stream<String> nullableStream = Stream.ofNullable(null);
        long count = nullableStream.count();
        System.out.println("Count of Nullable Stream: " + count);

        // Example 6: Parallel Streams
        List<Integer> largeList = IntStream.range(1, 1000000).boxed().collect(Collectors.toList());
        long startTime = System.currentTimeMillis();
        long parallelSum = largeList.parallelStream().mapToLong(Integer::longValue).sum();
        long endTime = System.currentTimeMillis();
        System.out.println("Parallel Stream Sum: " + parallelSum + ", Time Taken: " + (endTime - startTime) + "ms");

        // Example 7: FlatMap Example
        List<List<String>> nestedList = Arrays.asList(
                Arrays.asList("a", "b", "c"),
                Arrays.asList("d", "e", "f"),
                Arrays.asList("g", "h", "i")
        );
        List<String> flatList = nestedList.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        System.out.println("Flattened List: " + flatList);
    }
}
