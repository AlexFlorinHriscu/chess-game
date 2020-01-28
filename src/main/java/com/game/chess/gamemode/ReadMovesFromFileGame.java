package com.game.chess.gamemode;

import com.game.chess.exception.GameException;
import com.whitehatgaming.UserInputFile;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReadMovesFromFileGame extends GameMode {

    private static final String FOLDER = "resources";

    @Override
    public void readMoves() throws GameException {
        Optional<Path> file = getFile();
        if (file.isPresent()) {
            doMoves(file.get());
        }
    }

    private void doMoves(Path file) throws GameException {
        int[] values;
        try {
            UserInputFile userInputFile = new UserInputFile(file.toFile().getPath());
            int player = 1;
            while((values = userInputFile.nextMove()) != null) {
                this.console.displayPlayerTurnMessage(player);
                if (gameService.isCheckForPlayer(player)) {
                    System.out.println("Attention ! It is check !");
                }
                this.console.displayCurrentMove(values);
                if (this.gameService.processMove(values, player)) {
                    player *= -1;
                } else {
                    System.out.println("MOVE WAS INVALID");
                }
                this.chessTable.fullDisplay();
            }
        } catch (StringIndexOutOfBoundsException e) {
            throw new GameException("\nInvalid format of data inside file " + file.getFileName().toString());
        } catch (FileNotFoundException e) {
            throw new GameException("File doesn't exist");
        } catch (IOException e) {
            throw new GameException("There was a problem reading the file");
        }
    }

    private Optional<Path> getFile() {
        List<Path> files = listFiles();

        if (files.size() > 0) {
            displayFiles(files);
            return Optional.of(files.get(getUserChoice(files.size())));
        }

        return Optional.empty();
    }

    private List<Path> listFiles() {
        List<Path> files = new ArrayList<>();
        try (Stream<Path> paths = Files.walk(Paths.get(FOLDER))) {
            files = paths.filter(Files::isRegularFile).collect(Collectors.toList());
        } catch (IOException e) {
            System.out.println("There was a problem reading the resources folder.");
        }
        return files;
    }

    private void displayFiles(List<Path> files) {
        AtomicInteger index = new AtomicInteger(1);
        files.forEach(file -> {
            System.out.println(index + ". " + file);
            index.getAndIncrement();
        });
    }

    private int getUserChoice(int options) {
        System.out.print("Select file (type the corresponding number: ");
        String userInput = console.getPlayerInput();
        int selectedIndex;
        while (true) {
            try {
                selectedIndex = Integer.parseInt(userInput);
                if (selectedIndex > 0 && selectedIndex <= options) {
                    break;
                }
            } catch (NumberFormatException ex) {
                System.out.println("Please select correct number");
            }
        }
        return selectedIndex - 1;
    }

}
