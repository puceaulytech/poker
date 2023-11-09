package com.github.the10xdevs.poker.exceptions;

import java.util.Locale;

public class ParsingException extends Exception {
    private final String className;
    private final String token;

    public ParsingException(String className, String invalidToken) {
        super("invalid " + className.toLowerCase() + ": " + invalidToken);
        this.className = className;
        this.token = invalidToken;
    }

    @Override
    public String getLocalizedMessage() {
        Locale currentLocale = Locale.getDefault();
        if (currentLocale.getLanguage() == "fr") {
            return getFrenchClassName().toLowerCase() + " invalide: " + this.token;
        }
        return this.getMessage();
    }

    private String getFrenchClassName() {
        return switch (this.className) {
            case "Rank" -> "Rang";
            case "Suit" -> "Couleur";
            default -> "Inconnu";
        };
    }
}