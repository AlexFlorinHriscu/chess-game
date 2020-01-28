package com.game.chess.models;

import com.game.chess.validators.impl.KingValidator;

public class King extends Piece {

    public static final Character SYMBOL = 'k';

    public King(int player, char symbol) {
        this.player = player;
        this.setGameSymbol(symbol);
        this.pieceValidator = new KingValidator();
    }

}
