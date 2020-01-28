package com.game.chess.gamemode;

import com.game.chess.exception.GameException;
import com.game.chess.services.ConsoleService;
import com.game.chess.services.ChessTable;
import com.game.chess.services.GameService;

public abstract class GameMode {

    protected ConsoleService console;
    protected GameService gameService;
    protected ChessTable chessTable;

    GameMode() {
        this.console = new ConsoleService();
        this.gameService = new GameService();
        this.chessTable = ChessTable.getChessTable();
    }

    public abstract void readMoves() throws GameException;

    public void start() throws GameException {
        initialize();
        readMoves();
    }

    private void initialize() {
        ChessTable chessTable = ChessTable.getChessTable();
        chessTable.initialize();
    }

}
