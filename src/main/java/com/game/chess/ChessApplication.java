package com.game.chess;

import com.game.chess.game.ChessGame;

public class ChessApplication {

    public static void main(String[] args) {
        new ChessApplication().run();
    }

    private void run() {
        System.out.println("========== Chess Application ==========");
        ChessGame chessGame = new ChessGame();
        chessGame.newGame();
    }

}
