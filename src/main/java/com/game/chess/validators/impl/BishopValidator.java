package com.game.chess.validators.impl;

import com.game.chess.models.Piece;
import com.game.chess.validators.PieceValidator;

public class BishopValidator implements PieceValidator {

    @Override
    public boolean accepts(Piece piece, int[] move) {
        return isValidMove(move) && isCheckingPieceBetween(move, piece.getPlayer());
    }

    private boolean isValidMove(int[] move) {
        int x = Math.abs(move[1] - move[3]);
        int y = Math.abs(move[0] - move[2]);
        return x != 0 && x == y;
    }

    private boolean isCheckingPieceBetween(int[] move, int player) {
        int x, y;
        if (move[0] > move[2]) {
            if (move[1] > move[3]) {
                x = move[1] - 1;
                y = move[0] - 1;
                while(y > move[2]) {
                    if (chessTable.getTable()[x][y] != '_') {
                        return false;
                    }
                    y--;
                    x--;
                }
            } else {
                x = move[1] + 1;
                y = move[0] - 1;
                while(y > move[2]) {
                    if (chessTable.getTable()[x][y] != '_') {
                        return false;
                    }
                    y--;
                    x++;
                }
            }
        } else {
            if (move[1] > move[3]) {
                x = move[1] - 1;
                y = move[0] + 1;
                while(y < move[2]) {
                    if (chessTable.getTable()[x][y] != '_') {
                        return false;
                    }
                    y++;
                    x--;
                }
            } else {
                x = move[1] + 1;
                y = move[0] + 1;
                while(y < move[2]) {
                    if (chessTable.getTable()[x][y] != '_') {
                        return false;
                    }
                    y++;
                    x++;
                }
            }
        }
        return true;
    }

}
