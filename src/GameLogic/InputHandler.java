package GameLogic;

import WindowHandler.ConsolePrinter;

import java.util.HashMap;
import java.util.Scanner;

public class InputHandler {

    public static String newlyOccupiedField;

    static Scanner scanner = new Scanner(System.in);

    public static int input(char player){
        System.out.println("Spieler " + ((player == 'x') ? "1" : "2") + " ist am Zug");
        System.out.print("Feld: ");
        String input = scanner.nextLine();
        return Integer.parseInt(input);
    }

    public static HashMap<String, Character> place(int entrance, char player){
        HashMap<String, Character> gameState = FieldTranslator.read(ConsolePrinter.board, Translator.t);
        String fieldToPlace;

        if (entrance < 1 || entrance > 7) {
            System.out.println("bitte wähle einen der 7 Einwurfmöglichkeiten");
            return null;
        }

        else fieldToPlace = Integer.toString(entrance - 1) + 'A';

        if (gameState.get(fieldToPlace) != ' '){
            System.out.println("Spalte ist bereits gefüllt");
            return null;
        }
        fieldToPlace = dropDown(fieldToPlace, gameState);
        gameState.put(fieldToPlace, player);
        newlyOccupiedField = fieldToPlace;
        return gameState;
    }

    private static String dropDown(String finalField, HashMap<String, Character> gameState){
        for (int i = 1; i < 6; i++){
            if (gameState.get(finalField.charAt(0) + Character.toString(finalField.charAt(1) + 1)) != ' ') break;
            finalField = finalField.charAt(0) + Character.toString(finalField.charAt(1) + 1);
        }

        return finalField;
    }

    public String getNewlyOccupiedField(){return newlyOccupiedField;}

}
