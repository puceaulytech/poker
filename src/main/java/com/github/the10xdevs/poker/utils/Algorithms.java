package com.github.the10xdevs.poker.utils;

import java.util.*;
import java.util.stream.Collectors;

public class Algorithms {
    /**
     * Generate a map of occurrences
     * <br>
     * Example:
     * <pre>
     * {@code
     *  List<String> words = Arrays.asList("Foo", "Foo", "Foo", "Bar", "Bar", "Hello", "Hi");
     *  Map<Integer, Set<String>> occurrences = Algorithms.getOccurrences(words);
     *  assertEquals(Arrays.asList("Foo"), occurrences.get(3));
     *  assertEquals(Arrays.asList("Bar"), occurrences.get(2));
     *  assertEquals(Arrays.asList("Hello", "Hi"), occurrences.get(1));
     * }
     * </pre>
     *
     * @param arr The list of objects
     * @param <T> The type of the objects
     * @return The occurrences Map
     */
    public static <T> Map<Integer, Set<T>> getOccurrences(List<T> arr) {
        // This hashmap maps each object to its number of occurrences
        HashMap<T, Integer> objectToOccurrences = new HashMap<>();

        arr.stream().collect(Collectors.groupingBy(s -> s)).forEach((k, v) -> objectToOccurrences.put(k, v.size()));

        HashMap<Integer, Set<T>> occurrences = new HashMap<>();

        for (Map.Entry<T, Integer> entry : objectToOccurrences.entrySet()) {
            Integer occurrencesCount = entry.getValue();
            T obj = entry.getKey();

            if (occurrences.containsKey(occurrencesCount)) {
                occurrences.get(occurrencesCount).add(obj);
            } else {
                Set<T> s = new HashSet<>();
                s.add(obj);
                occurrences.put(occurrencesCount, s);
            }
        }

        return occurrences;
    }

    private Algorithms() {
        throw new IllegalStateException("Utility class");
    }
}
