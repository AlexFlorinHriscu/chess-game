package com.game.chess.services.impl;

import com.game.chess.services.UserInput;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

public class UserInputFile implements UserInput {

    private LineNumberReader reader;

    public UserInputFile(String fileName) throws FileNotFoundException {
        this.reader = new LineNumberReader(new FileReader(fileName));
    }

    @Override
    public int[] nextMove() throws IOException {
        String line = this.reader.readLine();
        if (line != null) {
            return new int[]{line.charAt(0) - 97, 56 - line.charAt(1), line.charAt(2) - 97, 56 - line.charAt(3)};
        } else {
            return null;
        }
    }

}
