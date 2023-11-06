package com.github.the10xdevs.poker.models;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    private Player playerOne;


    @Test
     void computeBestHandFours() {
        Player playerOne= Player.fromString("RCa RPi RCo RTr");
        Hand bestHand = playerOne.computeBestHand();

        assertEquals(HandType.FOUR_OF_A_KIND, bestHand.getType());
        assertEquals(Rank.KING, bestHand.getHighestRank());
    }
    @Test
    void computeBestHandThrees() {

        Player playerOne= Player.fromString("RCa RPi RCo ");
        Hand bestHand = playerOne.computeBestHand();

        assertEquals(HandType.THREE_OF_A_KIND, bestHand.getType());
        assertEquals(Rank.KING, bestHand.getHighestRank());
    }

    @Test
    void computeBestHandDoublePairs() {
        Player playerOne= Player.fromString("RCa RPi 5Ca 5Tr");
        Hand bestHand = playerOne.computeBestHand();

        assertEquals(HandType.DOUBLE_PAIR, bestHand.getType());
        assertEquals(Rank.KING, bestHand.getHighestRank());
    }

    @Test
    void computeBestHandPairs() {
        Player playerOne= Player.fromString("RCa RPi 5Co ");
        Hand bestHand = playerOne.computeBestHand();

        assertEquals(HandType.PAIR, bestHand.getType());
        assertEquals(Rank.KING, bestHand.getHighestRank());
    }

    @Test
    void computeBestHandHighestRank() {
        Player playerOne= Player.fromString("VCa 10Pi 5Co ");
        Hand bestHand = playerOne.computeBestHand();

        assertEquals(HandType.HIGH_CARD, bestHand.getType());
        assertEquals(Rank.JACK, bestHand.getHighestRank());
    }
}