package com.github.the10xdevs.poker.models;

import com.github.the10xdevs.poker.exceptions.ParsingException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CardTest {
    private Card card1;
    private Card card2;
    private Card card3;
    private Card card4;


    @BeforeEach
    void SetUp() throws ParsingException {
        card1 = Card.fromString("2Tr");
        card2 = Card.fromString("APi");
        card3 = Card.fromString("10Co");
        card4 = Card.fromString("RCa");
    }


    @Test
    void fromString() throws ParsingException {

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
        assertEquals(Suit.CLUB, card1.getSuit());
        assertEquals(Suit.SPADE, card2.getSuit());
        assertEquals(Suit.HEART, card3.getSuit());
        assertEquals(Suit.DIAMOND, card4.getSuit());
    }

    @Test
    void getRank() {
        assertEquals(Rank.TWO, card1.getRank());
        assertEquals(Rank.ACE, card2.getRank());
        assertEquals(Rank.TEN, card3.getRank());
        assertEquals(Rank.KING, card4.getRank());
    }
}