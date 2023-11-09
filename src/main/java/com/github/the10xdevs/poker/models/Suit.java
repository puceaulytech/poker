package com.github.the10xdevs.poker.models;

import com.github.the10xdevs.poker.exceptions.ParsingException;

/**
 * Represents the suit of a card
 */
public enum Suit {
    DIAMOND,
    CLUB,
    HEART,
    SPADE;

    public static Suit fromString(String repr) throws ParsingException {
        return switch (repr) {
            case "Tr" -> CLUB;
            case "Co" -> HEART;
            case "Pi" -> SPADE;
            case "Ca" -> DIAMOND;
            default -> throw new ParsingException("Suit", repr);
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
