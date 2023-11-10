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
        return switch (repr.toLowerCase()) {
            case "tr" -> CLUB;
            case "co" -> HEART;
            case "pi" -> SPADE;
            case "ca" -> DIAMOND;
            default -> throw new ParsingException("Suit", repr);
        };
    }

    @Override
    public String toString() {
        return switch (this) {
            case DIAMOND -> "carreau";
            case CLUB -> "trèfle";
            case HEART -> "coeur";
            case SPADE -> "pique";
        };
    }
}
