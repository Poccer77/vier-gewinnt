package GameLogic;

import UI.InputHandler;
import UI.Translator;
import UI.ConsolePrinter;

import java.io.IOException;
import java.util.HashMap;

public class Game {
    private final ConsolePrinter consolePrinter;
    private final Translator translator;
    private final InputHandler inputHandler;
    private final DetermineWin determineWin;

    public Game(ConsolePrinter consolePrinter, Translator translator, InputHandler inputHandler) {
        this.consolePrinter = consolePrinter;
        this.translator = translator;
        this.inputHandler = inputHandler;

        determineWin = new DetermineWin();
    }

    public GameResult run() throws IOException {
        initBoard();

        var characterGameResult = loop();

        return switch (characterGameResult) {
            default -> GameResult.UNENTSCHIEDEN;
            case GameCharacter.SPIELER_1 -> GameResult.SPIELER_1_GEWINNT;
            case GameCharacter.SPIELER_2 -> GameResult.SPIELER_2_GEWINNT;
        };
    }

    private void initBoard() {
        HashMap<Integer, Character> emptyField = new HashMap<>();

        for (String field : translator.getMapping().keySet()) {
            emptyField.put(translator.getMapping().get(field), null);
        }

        consolePrinter.build(emptyField);
    }

    private char loop() throws IOException {
        boolean isPlayerX = true;

        while (true) {
            char condition = getInputFromPlayer(isPlayerX ? GameCharacter.SPIELER_1 : GameCharacter.SPIELER_2);

            if (condition != GameCharacter.LEERES_FELD) {
                return condition;
            }

            isPlayerX = !isPlayerX;
        }
    }

    private char getInputFromPlayer(char player) throws IOException {
        HashMap<String, Character> newGameState;

        do {
            newGameState = inputHandler.place(player);
        } while (newGameState == null);

        consolePrinter.build(translator.draw(translator.getMapping(), newGameState));
        return determineWin.win(inputHandler.getNewlyOccupiedField(), newGameState);
    }
}
