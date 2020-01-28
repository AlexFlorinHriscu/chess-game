package com.game.chess.models;

import com.game.chess.validators.PieceValidator;

public abstract class Piece {

    private char gameSymbol;
    protected int player;
    protected PieceValidator pieceValidator;

    public PieceValidator getValidator() {
        return this.pieceValidator;
    }

    public int getPlayer() {
        return this.player;
    }

    public Character getGameSymbol() {
        return this.gameSymbol;
    }

    public void setGameSymbol(Character symbol) {
        this.gameSymbol = symbol;
    }
}
