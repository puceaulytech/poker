package com.github.the10xdevs.poker.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class HandTest {
    @Test
    void compareTo() {
        Hand h1 = new Hand(HandType.PAIR, Rank.ACE);
        Hand h2 = new Hand(HandType.HIGH_CARD, Rank.FOUR);

        assertTrue(h1.compareTo(h2) > 0);
    }

    @Test
    void compareToSameScore() {
        Hand h1 = new Hand(HandType.PAIR, Rank.ACE);
        Hand h2 = new Hand(HandType.PAIR, Rank.FOUR);

        assertTrue(h1.compareTo(h2) > 0);
    }
}