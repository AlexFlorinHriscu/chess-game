package com.game.chess.validators.impl;

import com.game.chess.models.Piece;
import com.game.chess.validators.PieceValidator;

public class KnightValidator implements PieceValidator {

    @Override
    public boolean accepts(Piece piece, int[] move) {
        return isValidMove(move);
    }

    private boolean isValidMove(int[] move) {
        int x = Math.abs(move[1] - move[3]);
        int y = Math.abs(move[0] - move[2]);
        return x * y == 2;
    }

}
