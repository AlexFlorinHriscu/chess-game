package com.game.chess.factory;

import com.game.chess.gamemode.GameMode;
import com.game.chess.gamemode.ReadMovesFromConsoleGame;
import com.game.chess.gamemode.ReadMovesFromFileGame;

public class GameModeFactory {

    public static GameMode getGameMode(String type) {
        GameMode game = null;
        switch (type) {
            case "console":
                game = new ReadMovesFromConsoleGame();
                break;
            case "file":
                game = new ReadMovesFromFileGame();
                break;
            default:
                break;
        }
        return game;
    }
}
