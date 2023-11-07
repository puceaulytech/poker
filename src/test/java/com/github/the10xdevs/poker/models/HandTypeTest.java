package com.github.the10xdevs.poker.models;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HandTypeTest {
    HandType pairHand;
    HandType doublePairHand;
    HandType threeOfAKindHand;
    HandType straightHand;
    HandType flushHand;
    HandType fullHouseHand;
    HandType fourOfAKindHand;
    HandType highCardHand;

    @Test
    void toStringTest() {
        assertEquals("carte haute", HandType.HIGH_CARD.toString());
        assertEquals("paire", HandType.PAIR.toString());
        assertEquals("double paire", HandType.DOUBLE_PAIR.toString());
        assertEquals("brelan", HandType.THREE_OF_A_KIND.toString());
        assertEquals("suite", HandType.STRAIGHT.toString());
        assertEquals("couleur", HandType.FLUSH.toString());
        assertEquals("main pleine", HandType.FULL_HOUSE.toString());
        assertEquals("carré", HandType.FOUR_OF_A_KIND.toString());
    }

    @Test
    void GetScoreTypeTest() {

        highCardHand = HandType.HIGH_CARD;
        assertEquals(0, highCardHand.getScore());

        pairHand = HandType.PAIR;
        assertEquals(1, pairHand.getScore());

        doublePairHand = HandType.DOUBLE_PAIR;
        assertEquals(2, doublePairHand.getScore());

        threeOfAKindHand = HandType.THREE_OF_A_KIND;
        assertEquals(3, threeOfAKindHand.getScore());

        straightHand = HandType.STRAIGHT;
        assertEquals(4, straightHand.getScore());

        flushHand = HandType.FLUSH;
        assertEquals(5, flushHand.getScore());

        fullHouseHand = HandType.FULL_HOUSE;
        assertEquals(6, fullHouseHand.getScore());

        fourOfAKindHand = HandType.FOUR_OF_A_KIND;
        assertEquals(7, fourOfAKindHand.getScore());
    }
}