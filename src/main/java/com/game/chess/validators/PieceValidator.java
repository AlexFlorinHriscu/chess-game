package com.game.chess.validators;

import com.game.chess.models.Piece;
import com.game.chess.services.ChessTable;

public interface PieceValidator {

    ChessTable chessTable = ChessTable.getChessTable();

    boolean accepts(Piece piece, int[] move);
    default void process(Piece piece, int[] move) {
        chessTable.getTable()[move[1]][move[0]] = '_';
        chessTable.getTable()[move[3]][move[2]] = piece.getGameSymbol();
    }

}
