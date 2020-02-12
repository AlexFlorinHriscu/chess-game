package com.game.chess.gamemode;

import com.game.chess.exception.GameException;
import com.game.chess.services.impl.UserInputConsole;
import java.io.IOException;

public class ReadMovesFromConsoleGame extends GameMode {

    public ReadMovesFromConsoleGame() {
        this.userInput = new UserInputConsole();
    }

    @Override
    public void readMoves() throws GameException {
        int[] values;
        int player = 1;
        while(true) {
            boolean moveIsValid = true;
            this.chessTable.fullDisplay();
            this.console.displayPlayerTurnMessage(player);
            if (gameService.isCheckForPlayer(player)) {
                System.out.println("Attention ! It is check !");
            }
            System.out.print("Give next move or press q to quit (example : e2e4): ");
            try {
                values = userInput.nextMove();
                if (values == null) {
                    System.out.print("\nGame was STOPPED !");
                    break;
                }
            } catch (IOException | StringIndexOutOfBoundsException e) {
                System.out.println("There was a problem reading the next move. Try again or press q to exit!");
                moveIsValid = false;
                values = null;
            }
            if (moveIsValid && this.gameService.processMove(values, player)) {
                player *= -1;
            } else {
                System.out.println("MOVE WAS INVALID");
            }
        }
    }

}
