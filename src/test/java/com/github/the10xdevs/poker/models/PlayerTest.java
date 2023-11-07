package com.github.the10xdevs.poker.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PlayerTest {
    private Player playerOne;


    @Test
    void computeBestHandFours() {
        Player playerOne = Player.fromString("RCa RPi RCo RTr");
        Hand bestHand = playerOne.computeBestHand();

        assertEquals(HandType.FOUR_OF_A_KIND, bestHand.getType());
        assertEquals(Rank.KING, bestHand.getHighestRank());
    }

    @Test
    void computeBestHandFull() {
        playerOne = Player.fromString("RPi RCa RCo 3Co 3Ca");
        Hand bestHand = playerOne.computeBestHand();

        assertEquals(HandType.FULL_HOUSE, bestHand.getType());
        assertEquals(Rank.KING, bestHand.getHighestRank());

        Player playerTwo = Player.fromString("DCo DPi DTr ACo APi");
        assertEquals(1, playerOne.compareTo(playerTwo));
    }

    @Test
    void computeBestHandThrees() {

        Player playerOne = Player.fromString("RCa RPi RCo ");
        Hand bestHand = playerOne.computeBestHand();

        assertEquals(HandType.THREE_OF_A_KIND, bestHand.getType());
        assertEquals(Rank.KING, bestHand.getHighestRank());
    }

    @Test
    void computeBestHandDoublePairs() {
        Player playerOne = Player.fromString("RCa RPi 5Ca 5Tr");
        Hand bestHand = playerOne.computeBestHand();

        assertEquals(HandType.DOUBLE_PAIR, bestHand.getType());
        assertEquals(Rank.KING, bestHand.getHighestRank());
    }

    @Test
    void computeBestHandPairs() {
        Player playerOne = Player.fromString("RCa RPi 5Co ");
        Hand bestHand = playerOne.computeBestHand();

        assertEquals(HandType.PAIR, bestHand.getType());
        assertEquals(Rank.KING, bestHand.getHighestRank());
    }

    @Test
    void computeBestHandHighestRank() {
        Player playerOne = Player.fromString("VCa 10Pi 5Co ");
        Hand bestHand = playerOne.computeBestHand();

        assertEquals(HandType.HIGH_CARD, bestHand.getType());
        assertEquals(Rank.JACK, bestHand.getHighestRank());
    }

    @Test
    void computeBestHandStraightTest() {
        playerOne = Player.fromString("RPi DCa VPi ACo 10Co");
        Hand bestHand = playerOne.computeBestHand();
        assertEquals(HandType.STRAIGHT, bestHand.getType());
        assertEquals(Rank.ACE, bestHand.getHighestRank());

        playerOne = Player.fromString("4Ca 7Pi 8Tr 6Tr 5Ca");
        bestHand = playerOne.computeBestHand();
        assertEquals(HandType.STRAIGHT, bestHand.getType());
        assertEquals(Rank.EIGHT, bestHand.getHighestRank());

        playerOne = Player.fromString("3Ca APi 2Tr 5Tr 4Ca");
        bestHand = playerOne.computeBestHand();
        assertEquals(HandType.STRAIGHT, bestHand.getType());
        assertEquals(Rank.FIVE, bestHand.getHighestRank());

        playerOne = Player.fromString("3Ca APi 2Tr 7Tr 4Ca");
        bestHand = playerOne.computeBestHand();
        assertEquals(HandType.HIGH_CARD, bestHand.getType());
    }
}