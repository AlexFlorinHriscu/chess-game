package com.game.chess.services;

import java.util.Scanner;

public class ConsoleService {

    public String getPlayerInput() {
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }

    public void displayPlayerTurnMessage(int player) {
        if (player > 0) {
            System.out.println("\n\nPlayer 1 TURN");
        } else {
            System.out.println("\n\nPlayer 2 TURN");
        }
    }

    public void displayCurrentMove(int[] values) {
        System.out.println("processing move");
        System.out.println((char) (97 + values[0]) + " " + (char) (56 - values[1]));
        System.out.println((char) (97 + values[2]) + " " + (char) (56 - values[3]));
    }

}
