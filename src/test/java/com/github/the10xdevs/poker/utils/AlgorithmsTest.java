package com.github.the10xdevs.poker.utils;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class AlgorithmsTest {
    @Test
    void getOccurrences() {
        List<String> testList = new ArrayList<>();
        testList.add("Salut");
        testList.add("Salut");
        testList.add("Hello");

        Map<Integer, Set<String>> result = Algorithms.getOccurrences(testList);

        assertIterableEquals(Set.of("Salut"), result.get(2));
        assertIterableEquals(Set.of("Hello"), result.get(1));
    }

    @Test
    void hasDuplicates() {
        List<Integer> arr1 = List.of(1, 2, 3, 4, 5);
        assertFalse(Algorithms.hasDuplicates(arr1));

        List<Integer> arr2 = List.of(1, 2, 3, 4, 5, 1, 5);
        assertTrue(Algorithms.hasDuplicates(arr2));
    }
}