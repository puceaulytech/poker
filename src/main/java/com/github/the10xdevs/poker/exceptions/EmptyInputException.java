package com.github.the10xdevs.poker.exceptions;

import java.util.Locale;

public class EmptyInputException extends Exception {
    public EmptyInputException() {
        super("empty input");
    }

    @Override
    public String getLocalizedMessage() {
        Locale currentLocale = Locale.getDefault();
        if (currentLocale.getLanguage().equals("fr")) {
            return "entrée vide";
        }
        return this.getMessage();
    }
}
