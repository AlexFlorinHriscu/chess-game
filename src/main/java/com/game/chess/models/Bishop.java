package com.game.chess.models;

import com.game.chess.validators.impl.BishopValidator;

public class Bishop extends Piece {

    public static final Character SYMBOL = 'b';

    public Bishop(int player, char symbol) {
        this.player = player;
        this.setGameSymbol(symbol);
        pieceValidator = new BishopValidator();
    }

}
