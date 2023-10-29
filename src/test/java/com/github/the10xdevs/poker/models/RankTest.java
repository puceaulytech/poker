package com.github.the10xdevs.poker.models;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


class RankTest {

    @Test
    void testFromStringValid() {
        Rank rank1 = Rank.fromString("A");
        assertEquals(Rank.ACE, rank1);

        Rank rank2 = Rank.fromString("R");
        assertEquals(Rank.KING, rank2);

        Rank rank3 = Rank.fromString("D");
        assertEquals(Rank.QUEEN, rank3);

        Rank rank4 = Rank.fromString("V");
        assertEquals(Rank.JACK, rank4);

        Rank rank5 = Rank.fromString("2");
        assertEquals(Rank.TWO, rank5);

        Rank rank6 = Rank.fromString("10");
        assertEquals(Rank.TEN, rank6);
    }

    @Test
    void testFromStringInvalid() {
        assertThrows(IllegalStateException.class, () -> {
            Rank.fromString("Invalid");
        });
    }

    @Test
    void testToString() {
        String str1 = Rank.ACE.toString();
        assertEquals("A", str1);

        String str2 = Rank.KING.toString();
        assertEquals("R", str2);

        String str3 = Rank.QUEEN.toString();
        assertEquals("D", str3);

        String str4 = Rank.JACK.toString();
        assertEquals("V", str4);

        String str5 = Rank.TWO.toString();
        assertEquals("2", str5);

        String str6 = Rank.TEN.toString();
        assertEquals("10", str6);
    }
}
