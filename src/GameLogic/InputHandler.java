package GameLogic;

import WindowHandler.ConsolePrinter;

import java.util.HashMap;
import java.util.Scanner;

public class InputHandler {

    public static String newlyOccupiedField;

    static Scanner scanner = new Scanner(System.in);

    public static int input(){
        System.out.println("Spieler 1 ist am Zug");
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

        else fieldToPlace = "0" + (Character.toString('@' + entrance));

        if (gameState.get(fieldToPlace) != ' '){
            System.out.println("Spalte ist bereits gefüllt");
            return null;
        }
        else gameState.put(fieldToPlace, player);
        fieldToPlace = dropDown(fieldToPlace, gameState);
        gameState.put(fieldToPlace, player);
        newlyOccupiedField = fieldToPlace;
        return gameState;
    }

    private static String dropDown(String initialField, HashMap<String, Character> gameState){
        for (int i = 1; i < 6; i++){
            if (gameState.get(initialField.charAt(0) + Character.toString(initialField.charAt(1) + 1)) != ' ') break;
            initialField = (Integer.parseInt(String.valueOf(initialField.charAt(0))) + 1) + initialField.substring(1);
        }

        return initialField;
    }

    public String getNewlyOccupiedField(){return newlyOccupiedField;}

}
