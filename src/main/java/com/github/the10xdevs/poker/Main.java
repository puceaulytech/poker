package com.github.the10xdevs.poker;

import com.github.the10xdevs.poker.models.Duel;
import com.github.the10xdevs.poker.models.Player;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Player playerOne = Player.readFromTerminal(reader);
        Player playerTwo = Player.readFromTerminal(reader);
        Duel game = new Duel(playerOne, playerTwo);
        game.play();
    }
}
