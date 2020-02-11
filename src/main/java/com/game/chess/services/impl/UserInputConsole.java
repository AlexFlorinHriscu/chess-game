package com.game.chess.services.impl;

import com.game.chess.services.UserInput;

public class UserInputConsole implements UserInput {

    private ConsoleService console;

    public UserInputConsole() {
        this.console = new ConsoleService();
    }

    @Override
    public int[] nextMove() throws StringIndexOutOfBoundsException {
        String line = this.console.getPlayerInput();
        if (line.equalsIgnoreCase("q")) {
            return null;
        }
        return new int[]{line.charAt(0) - 97, 56 - line.charAt(1), line.charAt(2) - 97, 56 - line.charAt(3)};
    }

}
