package com.game.chess.gamemode;

public class ReadMovesFromConsoleGame extends GameMode {

    @Override
    public void readMoves() {
        int[] values;
        int player = 1;
        while(true) {
            this.chessTable.fullDisplay();
            this.console.displayPlayerTurnMessage(player);
            if (gameService.isCheckForPlayer(player)) {
                System.out.println("Attention ! It is check !");
            }
            System.out.print("Give next move or q to quit in the format (example : e2e4): ");
            String line = this.console.getPlayerInput();
            if (line.equals("q") || line.equals("Q")) {
                break;
            }
            values = getMove(line);
            if (this.gameService.processMove(values, player)) {
                player *= -1;
            } else {
                System.out.println("MOVE WAS INVALID");
            }
       }
    }

    private int[] getMove(String line) {
        return new int[]{line.charAt(0) - 97, 56 - line.charAt(1), line.charAt(2) - 97, 56 - line.charAt(3)};
    }

}
