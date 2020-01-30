package com.game.chess.services;

import com.game.chess.factory.PieceFactory;
import com.game.chess.models.Piece;
import com.game.chess.validators.PieceValidator;

public class GameService {

    private ChessTable chessTable;

    public GameService() {
        this.chessTable = ChessTable.getChessTable();
    }

    public boolean processMove(int[] move, int player) {
        boolean moveValid = false;
        char symbolSource = chessTable.getPieceFromPosition(move[1], move[0]);
        Piece piece = PieceFactory.getPiece(symbolSource);
        if (piece != null && piece.getPlayer() == player) {
            char symbolDestination = chessTable.getPieceFromPosition(move[3], move[2]);
            if (symbolDestination == '_') {
                if (piece.getValidator().accepts(piece, move)) {
                    moveValid = true;
                } else {
                    System.out.println("Invalid move");
                }
            } else {
                Piece pieceDestination = PieceFactory.getPiece(symbolDestination);
                if (piece.getPlayer() != pieceDestination.getPlayer() && piece.getValidator().accepts(piece, move)) {
                    moveValid = true;
                }
            }
            if (moveValid) {
                char[][] backupTable = copyChessTable(chessTable.getTable());
                piece.getValidator().process(piece, move);
                boolean isCheck = false;
                if (piece.getPlayer() > 0) {
                    if (checkOnKing(ChessTable.KING_PLAYER1[0], ChessTable.KING_PLAYER1[1], player)) {
                        System.out.println("Player is in check");
                        isCheck = true;
                    }
                } else {
                    if (checkOnKing(ChessTable.KING_PLAYER2[0], ChessTable.KING_PLAYER2[1], player)) {
                        System.out.println("Player is in check");
                        isCheck = true;
                    }
                }
                if (!isCheck) {
                    System.out.println("Move was PROCESSED :");
                    return true;
                } else {
                    chessTable.setTable(backupTable);
                    System.out.println("Please do another move as this lets you in check");
                }
            }
        }
        return false;
    }

    public boolean isCheckForPlayer(int player) {
        if (player > 0) {
            return checkOnKing(ChessTable.KING_PLAYER1[0], ChessTable.KING_PLAYER1[1], player);
        } else {
            return checkOnKing(ChessTable.KING_PLAYER2[0], ChessTable.KING_PLAYER2[1], player);
        }
    }

    public boolean checkOnKing(int x, int y, int player) {
        char[][] table = chessTable.getTable();
        if (player == -1) {
            for (int i = 0; i < table.length; i++) {
                for (int j = 0; j < table[i].length; j++) {
                    if (Character.isUpperCase(table[i][j])) {
                        int[] values = new int[]{j, i, y, x};
                        Piece piece = PieceFactory.getPiece(table[i][j]);
                        PieceValidator pieceValidator = piece.getValidator();
                        if (pieceValidator.accepts(piece, values)) {
                            return true;
                        }
                    }
                }
            }
        } else {
            for (int i = 0; i < table.length; i++) {
                for (int j = 0; j < table[i].length; j++) {
                    if (Character.isLowerCase(table[i][j])) {
                        int[] values = new int[]{j, i, y, x};
                        Piece piece = PieceFactory.getPiece(table[i][j]);
                        PieceValidator pieceValidator = piece.getValidator();
                        if (pieceValidator.accepts(piece, values)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    private char[][] copyChessTable(char[][] source) {
        int dimmension = source.length;
        char[][] destination = new char[dimmension][dimmension];
        for (int i = 0; i < source.length; i++) {
            System.arraycopy(source[i], 0, destination[i], 0, source[i].length);
        }
        return destination;
    }

}
