package com.game.chess.factory;

import com.game.chess.models.Bishop;
import com.game.chess.models.King;
import com.game.chess.models.Knight;
import com.game.chess.models.Pawn;
import com.game.chess.models.Piece;
import com.game.chess.models.Queen;
import com.game.chess.models.Rook;

public class PieceFactory {

    public static Piece getPiece(char symbol) {
        Piece piece = null;
        int player1 = 1;
        int player2 = -1;
        switch (symbol) {
            case 'k':
                piece = new King(player2, symbol);
                break;
            case 'K':
                piece = new King(player1, symbol);
                break;
            case 'q':
                piece = new Queen(player2, symbol);
                break;
            case 'Q':
                piece = new Queen(player1, symbol);
                break;
            case 'p':
                piece = new Pawn(player2, symbol);
                break;
            case 'P':
                piece = new Pawn(player1, symbol);
                break;
            case 'r':
                piece = new Rook(player2, symbol);
                break;
            case 'R':
                piece = new Rook(player1, symbol);
                break;
            case 'n':
                piece = new Knight(player2, symbol);
                break;
            case 'N':
                piece = new Knight(player1, symbol);
                break;
            case 'b':
                piece = new Bishop(player2, symbol);
                break;
            case 'B':
                piece = new Bishop(player1, symbol);
                break;
            default:
                break;
        }
        return piece;
    }

}
