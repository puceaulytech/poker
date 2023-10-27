package com.github.the10xdevs.poker;

import com.github.the10xdevs.poker.models.Player;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Player playerOne = Player.readFromTerminal(reader);
        Player playerTwo = Player.readFromTerminal(reader);

        if (playerOne.compareTo(playerTwo) > 0) {
            System.out.println("Le joueur 1 gagne");
        } else {
            System.out.println("Le joueur 2 gagne");
        }
    }
}
