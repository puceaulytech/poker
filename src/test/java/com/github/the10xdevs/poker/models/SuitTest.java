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
        assertEquals("carreau", Suit.DIAMOND.toString());
        assertEquals("trèfle", Suit.CLUB.toString());
        assertEquals("pique", Suit.SPADE.toString());
        assertEquals("coeur", Suit.HEART.toString());
    }
}