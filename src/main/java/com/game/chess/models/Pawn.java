package com.game.chess.models;

import com.game.chess.validators.impl.PawnValidator;

public class Pawn extends Piece {

    public static final Character SYMBOL = 'p';

    public Pawn(int player, char symbol) {
        this.player = player;
        this.setGameSymbol(symbol);
        pieceValidator = new PawnValidator();
    }

}
