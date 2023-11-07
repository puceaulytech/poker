package com.github.the10xdevs.poker.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class HandTest {
    private Hand h1;
    private Hand h2;
    private Hand h3;
    private Hand h4;
    private Hand h5;


    @BeforeEach
    void SetUp() {
        h1 = new Hand(HandType.PAIR, Rank.ACE);
        h2 = new Hand(HandType.HIGH_CARD, Rank.FOUR);
        h3 = new Hand(HandType.DOUBLE_PAIR, Rank.SIX);
        h4 = new Hand(HandType.THREE_OF_A_KIND, Rank.FIVE);
        h5 = new Hand(HandType.FOUR_OF_A_KIND, Rank.NINE);


    }

    @Test
    void compareTo() {


        assertTrue(h1.compareTo(h2) > 0);
    }

    @Test
    void getHighestRankTest() {
        assertEquals(14, h1.getHighestRank().getNumberRank());
        assertEquals(4, h2.getHighestRank().getNumberRank());
        assertEquals(6, h3.getHighestRank().getNumberRank());
        assertEquals(5, h4.getHighestRank().getNumberRank());
        assertEquals(9, h5.getHighestRank().getNumberRank());
    }

    @Test
    void getTypeTest() {
        assertEquals(1, h1.getType().getScore());
        assertEquals(0, h2.getType().getScore());
        assertEquals(2, h3.getType().getScore());
        assertEquals(3, h4.getType().getScore());
        assertEquals(7, h5.getType().getScore());

    }

    @Test
    void compareToSameScore() {
        Hand h1 = new Hand(HandType.PAIR, Rank.ACE);
        Hand h2 = new Hand(HandType.PAIR, Rank.FOUR);

        assertTrue(h1.compareTo(h2) > 0);
    }

    @Test
    void toStringTest() {
        assertEquals("paire de A", h1.toString());
        assertEquals("carte haute de 4", h2.toString());
        assertEquals("double paire de 6", h3.toString());
        assertEquals("brelan de 5", h4.toString());
        assertEquals("carré de 9", h5.toString());

    }
}