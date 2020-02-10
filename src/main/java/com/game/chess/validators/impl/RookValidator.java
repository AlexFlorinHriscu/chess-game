package com.game.chess.validators.impl;

import com.game.chess.models.Piece;
import com.game.chess.validators.PieceValidator;

public class RookValidator implements PieceValidator {

    @Override
    public boolean accepts(Piece piece, int[] move) {
        return isValidMove(move) && isCheckingPieceBetween(move);
    }

    private boolean isValidMove(int[] move) {
        int x = Math.abs(move[1] - move[3]);
        int y = Math.abs(move[0] - move[2]);
        return (x > 0 && y == 0) || (y > 0 && x == 0);
    }

    private boolean isCheckingPieceBetween(int[] move) {
        int x = Math.abs(move[1] - move[3]);
        int y = Math.abs(move[0] - move[2]);
        if (x == 0) {
            if (move[0] < move[2]) {
                y = move[0] + 1;
                while (y < move[2]) {
                    if (CHESS_BOARD.getTable()[move[1]][y] != '_') {
                        return false;
                    }
                    y++;
                }
            } else {
                y = move[0] - 1;
                while (y > move[2]) {
                    if (CHESS_BOARD.getTable()[move[1]][y] != '_') {
                        return false;
                    }
                    y--;
                }
            }
        } else if (y == 0) {
            if (move[1] < move[3]) {
                x = move[1] + 1;
                while (x < move[3]) {
                    if (CHESS_BOARD.getTable()[x][move[0]] != '_') {
                        return false;
                    }
                    x++;
                }
            } else {
                x = move[1] - 1;
                while (x > move[3]) {
                    if (CHESS_BOARD.getTable()[x][move[0]] != '_') {
                        return false;
                    }
                    x--;
                }
            }
        }
        return true;
    }
}
