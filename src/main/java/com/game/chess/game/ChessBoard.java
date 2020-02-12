package com.game.chess.game;

import com.game.chess.models.Bishop;
import com.game.chess.models.King;
import com.game.chess.models.Knight;
import com.game.chess.models.Pawn;
import com.game.chess.models.Queen;
import com.game.chess.models.Rook;

public class ChessBoard {

    private static final ChessBoard chess = new ChessBoard();
    private final int DIMMENSION = 8;
    private char[][] chessTable = new char[DIMMENSION][DIMMENSION];

    public static int[] KING_PLAYER1;
    public static int[] KING_PLAYER2;

    static {
        KING_PLAYER1 = new int[]{7, 4};
        KING_PLAYER2 = new int[]{0, 4};
    }

    private ChessBoard() {
    }

    public static ChessBoard getChessTable() {
        return chess;
    }

    public char[][] getTable() {
        return chessTable;
    }
    public void setTable(char[][] table) {
        this.chessTable = table;
    }

    public char getPieceFromPosition(int x, int y) {
        return chessTable[x][y];
    }

    public void initialize() {
        initializeEmptyPositions();
        initializePawns();
        initializeRooks();
        initializeKnights();
        initializeBishops();
        initializeQueens();
        initializeKings();
    }

    private void initializeEmptyPositions() {
        for (int i = 2; i < DIMMENSION - 2; i++) {
            for (int j = 0; j < DIMMENSION; j++) {
                chessTable[i][j] = '_';
            }
        }
    }

    private void initializeRooks() {
        chessTable[0][0] = chessTable[0][DIMMENSION - 1] = Rook.SYMBOL;
        chessTable[DIMMENSION - 1][0] = chessTable[DIMMENSION - 1][DIMMENSION - 1] = Character.toUpperCase(Rook.SYMBOL);
    }

    private void initializeKnights() {
        chessTable[0][1] = chessTable[0][DIMMENSION - 2] = Knight.SYMBOL;
        chessTable[DIMMENSION - 1][1] = chessTable[DIMMENSION - 1][DIMMENSION - 2] = Character.toUpperCase(Knight.SYMBOL);
    }

    private void initializeBishops() {
        chessTable[0][2] = chessTable[0][DIMMENSION - 3] = Bishop.SYMBOL;
        chessTable[DIMMENSION - 1][2] = chessTable[DIMMENSION - 1][DIMMENSION - 3] = Character.toUpperCase(Bishop.SYMBOL);
    }

    private void initializeQueens() {
        chessTable[0][3] = Queen.SYMBOL;
        chessTable[DIMMENSION - 1][3] = Character.toUpperCase(Queen.SYMBOL);
    }

    private void initializeKings() {
        chessTable[0][4] = King.SYMBOL;
        chessTable[DIMMENSION - 1][4] = Character.toUpperCase(King.SYMBOL);
    }

    private void initializePawns() {
        for (int i = 0; i < DIMMENSION; i++) {
            chessTable[1][i] = Pawn.SYMBOL;
            chessTable[DIMMENSION - 2][i] = Character.toUpperCase(Pawn.SYMBOL);
        }
    }

    public void fullDisplay() {
        System.out.print("\n  ");
        for (int i = 0; i < DIMMENSION; i++) {
            System.out.print((char) ('a' + i) + " ");
        }
        for (int i = 0; i < DIMMENSION; i++) {
            System.out.print("\n" + (DIMMENSION - i) + " ");
            for (int j = 0; j < DIMMENSION; j++) {
                System.out.print(chessTable[i][j] + " ");
            }
            System.out.print(DIMMENSION - i);
        }
        System.out.print("\n  ");
        for (int i = 0; i < DIMMENSION; i++) {
            System.out.print((char) ('a' + i) + " ");
        }
    }

    public void display() {
        System.out.println();
        for (int i = 0; i < chessTable.length; i++) {
            for (int j = 0; j < chessTable[i].length; j++) {
                System.out.print(chessTable[i][j]);
                System.out.print(' ');
            }
            System.out.println();
        }
    }
}
