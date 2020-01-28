package com.game.chess.models;

import com.game.chess.validators.impl.RookValidator;

public class Rook extends Piece {

    public static final Character SYMBOL = 'r';

    public Rook(int player, char symbol) {
        this.player = player;
        this.setGameSymbol(symbol);
        this.pieceValidator = new RookValidator();
    }

}
