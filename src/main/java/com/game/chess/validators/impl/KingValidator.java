package com.game.chess.validators.impl;

import com.game.chess.models.Piece;
import com.game.chess.services.ChessTable;
import com.game.chess.validators.PieceValidator;

public class KingValidator implements PieceValidator {

    @Override
    public boolean accepts(Piece piece, int[] move) {
        return isValidMove(move);
    }

    @Override
    public void process(Piece piece, int[] move) {
        chessTable.getTable()[move[1]][move[0]] = '_';
        chessTable.getTable()[move[3]][move[2]] = piece.getGameSymbol();
        if (piece.getPlayer() > 0) {
            ChessTable.KING_PLAYER1 = new int[] {move[3], move[2]};
        } else {
            ChessTable.KING_PLAYER2 = new int[] {move[3], move[2]};
        }
    }

    private boolean isValidMove(int[] move) {
        int x = Math.abs(move[1] - move[3]);
        int y = Math.abs(move[0] - move[2]);
        return (x == 1 && x == y) ||  (x == 1 && y == 0) || (x == 0 && y == 1);
    }

}
