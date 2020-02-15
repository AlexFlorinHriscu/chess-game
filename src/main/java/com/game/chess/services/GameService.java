package com.game.chess.services;

public interface GameService {

    boolean processMove(int[] move, int player);
    boolean isCheckForPlayer(int player);

}