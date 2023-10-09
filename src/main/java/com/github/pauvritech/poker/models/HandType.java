package com.github.pauvritech.poker.models;

public enum HandType {
    /**
     * Simple value of a card
     */
    HIGH_CARD(0),
    /**
     * Two cards with the same value
     */
    PAIR(1);

    private final int score;

    HandType(int score) {
        this.score = score;
    }

    public int getScore() { return this.score; }

    @Override
    public String toString() {
        return switch (this) {
            case HIGH_CARD -> "carte haute";
            case PAIR -> "paire";
        };
    }
}
