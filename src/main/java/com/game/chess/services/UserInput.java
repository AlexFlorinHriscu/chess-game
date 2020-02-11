package com.game.chess.services;

import com.game.chess.exception.GameException;
import java.io.IOException;

public interface UserInput {
    int[] nextMove() throws IOException, GameException;
}
