package UI;

import java.util.HashMap;
import java.util.Scanner;

public class InputHandler {
    private final Translator translator;
    private final ConsolePrinter consolePrinter;

    private final Scanner scanner = new Scanner(System.in);
    private String newlyOccupiedField;

    public InputHandler(Translator translator, ConsolePrinter consolePrinter) {
        this.consolePrinter = consolePrinter;
        this.translator = translator;
    }

    public HashMap<String, Character> place(char player) {
        int entrance = input(player);

        HashMap<String, Character> gameState = translator.read(consolePrinter.getBoard(), translator.getMapping());
        String fieldToPlace;

        if (entrance < 1 || entrance > 7) {
            System.out.println("Bitte wähle einen der 7 Einwurfmöglichkeiten");
            return null;
        }

        fieldToPlace = Integer.toString(entrance - 1) + 'A';

        if (gameState.get(fieldToPlace) != ' '){
            System.out.println("Spalte ist bereits gefüllt");
            return null;
        }

        fieldToPlace = dropDown(fieldToPlace, gameState);
        gameState.put(fieldToPlace, player);
        newlyOccupiedField = fieldToPlace;

        return gameState;
    }

    private int input(char player) {
        System.out.println("Spieler " + ((player == GameCharacter.SPIELER_1) ? "1" : "2") + " ist am Zug");
        System.out.print("Feld: ");

        String input = scanner.nextLine();

        try {
            return Integer.parseInt(input);
        }
        catch (NumberFormatException exc) {
            return -1;
        }
    }

    private String dropDown(String finalField, HashMap<String, Character> gameState) {
        for (int i = 1; i < 6; i++) {
            if (gameState.get(finalField.charAt(0) + Character.toString(finalField.charAt(1) + 1)) != ' ')
                break;

            finalField = finalField.charAt(0) + Character.toString(finalField.charAt(1) + 1);
        }

        return finalField;
    }

    public String getNewlyOccupiedField() {
        return newlyOccupiedField;
    }
}
