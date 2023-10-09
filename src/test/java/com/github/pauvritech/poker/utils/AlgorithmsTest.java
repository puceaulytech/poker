package com.github.pauvritech.poker.utils;

import org.junit.jupiter.api.Test;

import java.util.*;

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
}