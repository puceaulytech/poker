package com.github.pauvritech.poker.models;

/**
 * Represents the suit of a card
 */
public enum Suit {
    DIAMOND,
    CLUB,
    HEART,
    SPADE;

    public static Suit fromString(String repr) {
        return switch (repr) {
            case "Tr" -> CLUB;
            case "Co" -> HEART;
            case "Pi" -> SPADE;
            case "Ca" -> DIAMOND;
            default -> throw new IllegalStateException("Invalid suit: " + repr);
        };
    }

    @Override
    public String toString() {
        return switch (this) {
            case DIAMOND -> "Ca";
            case CLUB -> "Tr";
            case HEART -> "Co";
            case SPADE -> "Pi";
        };
    }
}
