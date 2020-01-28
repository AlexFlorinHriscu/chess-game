package com.game.chess.models;

import com.game.chess.validators.impl.KnightValidator;

public class Knight extends Piece {

    public static final Character SYMBOL = 'n';

    public Knight(int player, char symbol) {
        this.player = player;
        this.setGameSymbol(symbol);
        pieceValidator = new KnightValidator();
    }

}
