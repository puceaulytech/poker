package com.github.the10xdevs.poker.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


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

        assertThrows(IllegalStateException.class, () -> Rank.fromString("Invalid"));
    }

    @Test
    void testFromStringInvalid() {
        assertThrows(IllegalStateException.class, () -> Rank.fromString("Invalid"));
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

        String str6 = Rank.THREE.toString();
        assertEquals("3", str6);

        String str10 = Rank.FOUR.toString();
        assertEquals("4", str10);

        String str7 = Rank.FIVE.toString();
        assertEquals("5", str7);

        String str8 = Rank.SIX.toString();
        assertEquals("6", str8);

        String str9 = Rank.TEN.toString();
        assertEquals("10", str9);

        String str11 = Rank.SEVEN.toString();
        assertEquals("7", str11);

        String str12 = Rank.EIGHT.toString();
        assertEquals("8", str12);

        String str13 = Rank.NINE.toString();
        assertEquals("9", str13);
    }

    @Test
    void TestGetNumberRank() {
        Rank rank1 = Rank.fromString("A");
        assertEquals(14, rank1.getNumberRank());
        Rank rank2 = Rank.fromString("10");
        assertEquals(10, rank2.getNumberRank());
        Rank rank3 = Rank.fromString("9");
        assertEquals(9, rank3.getNumberRank());
        Rank rank4 = Rank.fromString("8");
        assertEquals(8, rank4.getNumberRank());
        Rank rank5 = Rank.fromString("7");
        assertEquals(7, rank5.getNumberRank());
        Rank rank6 = Rank.fromString("6");
        assertEquals(6, rank6.getNumberRank());

        Rank rank7 = Rank.fromString("5");
        assertEquals(5, rank7.getNumberRank());
        Rank rank8 = Rank.fromString("4");
        assertEquals(4, rank8.getNumberRank());
        Rank rank9 = Rank.fromString("3");
        assertEquals(3, rank9.getNumberRank());

        assertThrows(IllegalStateException.class, () -> Rank.fromString("invalid"));
    }
}
