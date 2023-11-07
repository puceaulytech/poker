package com.github.the10xdevs.poker.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SuitTest {

    @Test
    void testFromStringClubs() {
        Suit suit = Suit.fromString("Tr");
        assertEquals(Suit.CLUB, suit);
    }

    @Test
    void toStringTest() {
        assertEquals("Ca", Suit.DIAMOND.toString());
        assertEquals("Tr", Suit.CLUB.toString());
        assertEquals("Pi", Suit.SPADE.toString());
        assertEquals("Co", Suit.HEART.toString());
    }

    @Test
    void testFromStringHearts() {
        Suit suit = Suit.fromString("Co");
        assertEquals(Suit.HEART, suit);
        assertThrows(IllegalStateException.class, () -> Suit.fromString("invalid"));
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