package com.game.chess.models;

import com.game.chess.validators.impl.QueenValidator;

public class Queen extends Piece {

    public static final Character SYMBOL = 'q';

    public Queen(int player, char symbol) {
        this.player = player;
        this.setGameSymbol(symbol);
        this.pieceValidator = new QueenValidator();
    }

}
