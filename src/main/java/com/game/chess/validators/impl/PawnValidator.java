package com.game.chess.validators.impl;

import com.game.chess.models.Piece;
import com.game.chess.validators.PieceValidator;

public class PawnValidator implements PieceValidator {

    @Override
    public boolean accepts(Piece piece, int[] move) {
        if (!isGoingForward(move, piece.getPlayer()))
            return false;
        if (chessTable.getPieceFromPosition(move[3], move[2]) != '_') {
            return isValidAttackMove(move);
        } else {
            return isValidMove(move) || isValidTwoSpacesMove(piece, move);
        }
    }

    private boolean isValidMove(int[] move) {
        int x = Math.abs(move[1] - move[3]);
        int y = Math.abs(move[0] - move[2]);
        return x == 1 && y == 0;
    }

    private boolean isValidTwoSpacesMove(Piece piece, int[] move) {
        if (!isStartingFromRightPosition(move, piece.getPlayer()) || isPieceBetween(move, piece.getPlayer())) {
            return false;
        }
        int x = Math.abs(move[1] - move[3]);
        int y = Math.abs(move[0] - move[2]);
        return x == 2 && y == 0;
    }

    private boolean isPieceBetween(int[] move, int player) {
        if (player > 0 && chessTable.getTable()[move[1]-1][move[0]] != '_') {
            return true;
        }
        if (player < 0 && chessTable.getTable()[move[1]+1][move[0]] != '_') {
            return true;
        }
        return false;
    }

    private boolean isStartingFromRightPosition(int[] move, int player) {
        if (player > 0 && move[1] != 6) {
            return false;
        }
        if (player < 0 && move[1] != 1) {
            return false;
        }
        return true;
    }

    private boolean isValidAttackMove(int[] move) {
        int x = Math.abs(move[1] - move[3]);
        int y = Math.abs(move[0] - move[2]);
        return x == 1 && x == y;
    }

    private boolean isGoingForward(int[] move, int player) {
        if (player > 0 && move[3] >= move[1])
            return false;
        if (player < 0 && move[3] <= move[1])
            return false;
        return true;
    }

}
