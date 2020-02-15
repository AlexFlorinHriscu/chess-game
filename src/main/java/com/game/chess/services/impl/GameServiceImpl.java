package com.game.chess.services.impl;

import com.game.chess.factory.PieceFactory;
import com.game.chess.game.ChessBoard;
import com.game.chess.models.Piece;
import com.game.chess.services.GameService;
import java.util.function.Predicate;

public class GameServiceImpl implements GameService {

    private ChessBoard chessBoard;
    private char[][] backupChessTable;
    private int[] backupKingPosition;

    public GameServiceImpl() {
        this.chessBoard = ChessBoard.getChessTable();
    }

    public boolean processMove(int[] move, int player) {
        char symbolSource = chessBoard.getPieceFromPosition(move[1], move[0]);
        Piece piece = PieceFactory.getPiece(symbolSource);
        if (piece != null && piece.getPlayer() == player) {
            if (isValidMove(move, piece)) {
                backupState(player);
                piece.getValidator().process(piece, move);
                if (!isCheckForPlayer(player)) {
                    System.out.println("Move was PROCESSED");
                    return true;
                } else {
                    restoreState(player);
                    System.out.println("Please do another move as this lets you in check");
                }
            }
        }
        return false;
    }

    private boolean isValidMove(int[] move, Piece piece) {
        char symbolDestination = chessBoard.getPieceFromPosition(move[3], move[2]);
        if (symbolDestination == '_') {
            return piece.getValidator().accepts(piece, move);
        } else {
            Piece pieceDestination = PieceFactory.getPiece(symbolDestination);
            return piece.getPlayer() != pieceDestination.getPlayer() && piece.getValidator().accepts(piece, move);
        }
    }

    public boolean isCheckForPlayer(int player) {
        char[][] table = chessBoard.getTable();
        Predicate<Character> isPlayer1Piece = Character::isUpperCase;
        Predicate<Character> isPlayer2Piece = Character::isLowerCase;

        if (player > 0) {
            return isCheck(table, ChessBoard.KING_PLAYER1[0], ChessBoard.KING_PLAYER1[1], isPlayer2Piece);
        } else {
            return isCheck(table, ChessBoard.KING_PLAYER2[0], ChessBoard.KING_PLAYER2[1], isPlayer1Piece);
        }
    }

    private boolean isCheck(char[][] table, int x, int y, Predicate<Character> isOpponentPiece) {
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                if (isOpponentPiece.test(table[i][j])) {
                    int[] values = new int[]{j, i, y, x};
                    Piece piece = PieceFactory.getPiece(table[i][j]);
                    if (piece.getValidator().accepts(piece, values)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private void backupState(int player) {
        this.backupChessTable = copyChessTable(chessBoard.getTable());
        if (player > 0) {
            this.backupKingPosition = new int[] {ChessBoard.KING_PLAYER1[0], ChessBoard.KING_PLAYER1[1]};
        } else {
            this.backupKingPosition = new int[] {ChessBoard.KING_PLAYER2[0], ChessBoard.KING_PLAYER2[1]};
        }
    }

    private void restoreState(int player) {
        chessBoard.setTable(backupChessTable);
        if (player > 0) {
            ChessBoard.KING_PLAYER1 = new int[] {backupKingPosition[0], backupKingPosition[1]};
        } else {
            ChessBoard.KING_PLAYER2 = new int[] {backupKingPosition[0], backupKingPosition[1]};
        }
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