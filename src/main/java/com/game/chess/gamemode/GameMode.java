package com.game.chess.gamemode;

import com.game.chess.exception.GameException;
import com.game.chess.services.GameService;
import com.game.chess.services.UserInput;
import com.game.chess.services.impl.ConsoleService;
import com.game.chess.game.ChessBoard;
import com.game.chess.services.impl.GameServiceImpl;

public abstract class GameMode {

    protected UserInput userInput;
    protected ConsoleService console;
    protected GameService gameService;
    protected ChessBoard chessTable;

    GameMode() {
        this.console = new ConsoleService();
        this.gameService = new GameServiceImpl();
    }

    public abstract void readMoves() throws GameException;

    public void start() throws GameException {
        initialize();
        readMoves();
    }

    private void initialize() {
        ChessBoard.getChessTable().initialize();
        this.chessTable = ChessBoard.getChessTable();
    }

}
