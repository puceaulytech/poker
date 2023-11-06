package com.github.the10xdevs.poker.models;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HandTypeTest {
    HandType pairHand;
    HandType doublePairHand;
    HandType fourOfAKindHand;
    HandType threeOfAKindHand;
    HandType highCardHand;

    @Test
    void TestEnumHandTypeValues(){
        assertEquals(5, HandType.values().length);

    }
    @Test
    void toStringTest(){
        assertEquals("carte haute",HandType.HIGH_CARD.toString());
        assertEquals("paire",HandType.PAIR.toString());

        assertEquals("double paire",HandType.DOUBLE_PAIR.toString());

        assertEquals("brelan",HandType.THREE_OF_A_KIND.toString());

        assertEquals("carré",HandType.FOUR_OF_A_KIND.toString());

    }

    @Test
    void HandTypeLengthTest(){
        assertEquals(5, HandType.values().length);
    }
    @Test
    void GetScoreTypeTest(){

        highCardHand=HandType.HIGH_CARD;
        assertEquals(0,highCardHand.getScore());

        pairHand=HandType.PAIR;
        assertEquals(1,pairHand.getScore());

        doublePairHand=HandType.DOUBLE_PAIR;
        assertEquals(2,doublePairHand.getScore());

        threeOfAKindHand=HandType.THREE_OF_A_KIND;
        assertEquals(3,threeOfAKindHand.getScore());

        fourOfAKindHand=HandType.FOUR_OF_A_KIND;
        assertEquals(7,fourOfAKindHand.getScore());

    }



}