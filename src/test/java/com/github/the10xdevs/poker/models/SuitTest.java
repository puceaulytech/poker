package com.github.the10xdevs.poker.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SuitTest {

    @Test
    void testFromStringClubs() {
        Suit suit = Suit.fromString("Tr");
        assertEquals(Suit.CLUB, suit);
    }

    @Test
    void testFromStringHearts() {
        Suit suit = Suit.fromString("Co");
        assertEquals(Suit.HEART, suit);
    }

    @Test
    void testFromStringSpades() {
        Suit suit = Suit.fromString("Pi");
        assertEquals(Suit.SPADE, suit);
    }

    @Test
    void testFromStringDiamonds() {
        Suit suit = Suit.fromString("Ca");
        assertEquals(Suit.DIAMOND, suit);
    }
}