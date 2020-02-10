package com.game.chess.validators;

import com.game.chess.models.Piece;
import com.game.chess.game.ChessBoard;

public interface PieceValidator {

    ChessBoard CHESS_BOARD = ChessBoard.getChessTable();

    boolean accepts(Piece piece, int[] move);
    default void process(Piece piece, int[] move) {
        CHESS_BOARD.getTable()[move[1]][move[0]] = '_';
        CHESS_BOARD.getTable()[move[3]][move[2]] = piece.getGameSymbol();
    }

}
