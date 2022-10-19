import GameLogic.DetermineWin;
import GameLogic.FieldTranslator;
import GameLogic.InputHandler;
import GameLogic.Translator;
import WindowHandler.ConsolePrinter;

import java.io.IOException;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws InterruptedException, IOException {

        HashMap<Integer, Character> emptyField = new HashMap<>();

        for (String field : Translator.t.keySet()){
            emptyField.put(Translator.t.get(field), null);
        }
        ConsolePrinter.build(emptyField);
        char player;
        char condition;

        while (true) {

            HashMap<String, Character> newGameState;

            player = 'x';
            do {
                int input = InputHandler.input(player);
                newGameState = InputHandler.place(input, player);
            } while (newGameState == null);
            ConsolePrinter.build(FieldTranslator.draw(Translator.t, newGameState));
            condition = DetermineWin.win(InputHandler.newlyOccupiedField, newGameState);
            if (condition != ' ') break;

            player = 'o';
            do {
                int input = InputHandler.input(player);
                newGameState = InputHandler.place(input, player);
            } while (newGameState == null);
            ConsolePrinter.build(FieldTranslator.draw(Translator.t, newGameState));
            condition = DetermineWin.win(InputHandler.newlyOccupiedField, newGameState);
            if (condition != ' ') break;
        }

        System.out.println((condition == 'd') ? "Unentschieden" : (((condition == 'x') ? "Spieler 1" : "Spieler 2") + " hat gewonnen!"));
    }
}
