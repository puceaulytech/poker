package com.github.the10xdevs.poker.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CardTest {
    private Card c1;
    private Card c2;
    private Card c3;

    @BeforeEach
    void setUp() {
        c1 = Card.fromString("2Tr");
        c2 = Card.fromString("APi");
        c3 = Card.fromString("10Co");

    }

    @Test
    void fromString() {

        assertEquals(Rank.TWO, c1.getRank());
        assertEquals(Suit.CLUB, c1.getSuit());


        assertEquals(Rank.ACE, c2.getRank());
        assertEquals(Suit.SPADE, c2.getSuit());


        assertEquals(Rank.TEN, c3.getRank());
        assertEquals(Suit.HEART, c3.getSuit());



    }

    @Test
    void getSuit() {
        assertEquals(c1.getSuit(), Suit.CLUB);
        assertEquals(c2.getSuit(), Suit.SPADE);
        assertEquals(c3.getSuit(), Suit.HEART);


    }

    @Test
    void getRank() {
        assertEquals(c1.getRank(), Rank.TWO);
        assertEquals(c2.getRank(), Rank.ACE);
        assertEquals(c3.getRank(), Rank.TEN);
    }
}