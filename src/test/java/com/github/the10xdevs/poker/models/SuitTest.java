package com.github.the10xdevs.poker.models;

import com.github.the10xdevs.poker.exceptions.ParsingException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SuitTest {

    @Test
    void testFromString() throws ParsingException {
        Suit suit = Suit.fromString("Tr");
        assertEquals(Suit.CLUB, suit);

        suit = Suit.fromString("Co");
        assertEquals(Suit.HEART, suit);

        suit = Suit.fromString("Pi");
        assertEquals(Suit.SPADE, suit);

        suit = Suit.fromString("Ca");
        assertEquals(Suit.DIAMOND, suit);

        assertThrows(ParsingException.class, () -> Suit.fromString("invalid"));
    }

    @Test
    void toStringTest() {
        assertEquals("Ca", Suit.DIAMOND.toString());
        assertEquals("Tr", Suit.CLUB.toString());
        assertEquals("Pi", Suit.SPADE.toString());
        assertEquals("Co", Suit.HEART.toString());
    }
}