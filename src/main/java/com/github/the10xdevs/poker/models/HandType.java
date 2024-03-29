package com.github.the10xdevs.poker.models;

public enum HandType {
    /**
     * Simple value of a card
     */
    HIGH_CARD(0),
    /**
     * Two cards with the same value
     */
    PAIR(1),
    /**
     * Two different pairs
     */
    DOUBLE_PAIR(2),
    /**
     * Three cards with the same value
     */
    THREE_OF_A_KIND(3),
    /**
     * Five cards of sequential value
     */
    STRAIGHT(4),
    /**
     * Five cards with the same suit
     */
    FLUSH(5),
    /**
     * One pair and a three of a kind
     */
    FULL_HOUSE(6),
    /**
     * Four cards with the same value
     */
    FOUR_OF_A_KIND(7),
    /**
     * A straight where all the cards have the same suit
     */
    STRAIGHT_FLUSH(8);

    private final int score;

    HandType(int score) {
        this.score = score;
    }

    public int getScore() {
        return this.score;
    }

    @Override
    public String toString() {
        return switch (this) {
            case HIGH_CARD -> "carte haute";
            case PAIR -> "paire";
            case DOUBLE_PAIR -> "double paire";
            case THREE_OF_A_KIND -> "brelan";
            case STRAIGHT -> "suite";
            case FULL_HOUSE -> "full";
            case FOUR_OF_A_KIND -> "carré";
            case FLUSH -> "couleur";
            case STRAIGHT_FLUSH -> "quinte flush";
        };
    }
}