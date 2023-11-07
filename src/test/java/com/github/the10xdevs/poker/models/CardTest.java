package com.github.the10xdevs.poker.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

class CardTest {
    private Card card1;
    private Card card2;
    private Card card3;
    private Card card4;


    @BeforeEach
    void SetUp() {
        card1 = Card.fromString("2Tr");
        card2 = Card.fromString("APi");
        card3 = Card.fromString("10Co");
        card4 = Card.fromString("RCa");

    }


    @Test
    void fromString() {

        Card c1 = new Card(Suit.CLUB, Rank.TWO);
        assertEquals(Rank.TWO, c1.getRank());
        assertEquals(Suit.CLUB, c1.getSuit());
        assertEquals(c1, Card.fromString("2Tr"));

        Card c2 = new Card(Suit.SPADE, Rank.ACE);
        assertEquals(Rank.ACE, c2.getRank());
        assertEquals(Suit.SPADE, c2.getSuit());
        assertEquals(c2, Card.fromString("APi"));

        Card c3 = Card.fromString("10Co");
        assertEquals(Rank.TEN, c3.getRank());
        assertEquals(Suit.HEART, c3.getSuit());
        assertEquals(c3, Card.fromString("10Co"));

    }

    @Test
    void getSuit() {
        assertEquals(card1.getSuit(), Suit.CLUB);
        assertEquals(card2.getSuit(), Suit.SPADE);
        assertEquals(card3.getSuit(), Suit.HEART);
        assertEquals(card4.getSuit(), Suit.DIAMOND);


    }

    @Test
    void getRank() {
        assertEquals(card1.getRank(), Rank.TWO);
        assertEquals(card2.getRank(), Rank.ACE);
        assertEquals(card3.getRank(), Rank.TEN);
        assertEquals(card4.getRank(), Rank.KING);
    }
}