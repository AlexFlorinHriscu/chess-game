package com.game.chess.game;

import com.game.chess.exception.GameException;
import com.game.chess.factory.GameModeFactory;
import com.game.chess.gamemode.GameMode;
import com.game.chess.services.impl.ConsoleService;

public class ChessGame {

    private static final String READ_MOVES_FROM_FILE = "file";
    private static final String READ_MOVES_FROM_CONSOLE = "console";

    private ConsoleService console;

    public ChessGame() {
        this.console = new ConsoleService();
    }

    public void newGame() {
        GameMode game = GameModeFactory.getGameMode(selectGameMode());
        try {
            game.start();
        } catch (GameException e) {
            System.out.println("\n\nGame Stopped due to: " + e.getMessage());
        }
    }

    private String selectGameMode() {
        System.out.print("\nPlease select game mode :\n1. Read moves from file\n2. Play from console\nYour selection (1/2): ");
        String gameMode = "";
        boolean invalidInput = true;
        while(invalidInput) {
            switch(console.getPlayerInput()) {
                case "1":
                    gameMode = READ_MOVES_FROM_FILE;
                    invalidInput = false;
                    break;
                case "2":
                    gameMode = READ_MOVES_FROM_CONSOLE;
                    invalidInput = false;
                    break;
                default:
                    System.out.println("Sorry, invalid choice. Please type 1 or 2 !");
            }
        }
        return gameMode;
    }

}
