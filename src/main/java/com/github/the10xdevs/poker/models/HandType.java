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
     * Three cards with the same value
     */
    THREE_OF_A_KIND(3),
    /**
     * Four cards with the same value
     */
    FOUR_OF_A_KIND(7);

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
            case THREE_OF_A_KIND -> "brelan";
            case FOUR_OF_A_KIND -> "carré";
        };
    }
}
