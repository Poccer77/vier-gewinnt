import GameLogic.DetermineWin;
import GameLogic.FieldTranslator;
import GameLogic.InputHandler;
import GameLogic.Translator;
import WindowHandler.ConsolePrinter;
import com.google.common.collect.HashBiMap;

import java.awt.*;
import java.io.IOException;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws InterruptedException, IOException {

        HashMap<Integer, Character> emptyField = new HashMap<>();

        for (String field : Translator.t.keySet()){
            emptyField.put(Translator.t.get(field), null);
        }
        ConsolePrinter.build(emptyField);
        System.out.println(Translator.t);
        char player;

        while (true) {

            HashMap<String, Character> newGameState;
            player = 'x';
            do {
                int input = InputHandler.input(player);
                newGameState = InputHandler.place(input, player);
            } while (newGameState == null);
            ConsolePrinter.build(FieldTranslator.draw(Translator.t, newGameState));
            (DetermineWin.win(InputHandler.newlyOccupiedField, newGameState) = ' ') ?
            System.out.println(newGameState);
            player = 'o';
            do {
                int input = InputHandler.input(player);
                newGameState = InputHandler.place(input, player);
            } while (newGameState == null);
            ConsolePrinter.build(FieldTranslator.draw(Translator.t, newGameState));
            if (DetermineWin.win(InputHandler.newlyOccupiedField, newGameState) == 'o') break;
            System.out.println(newGameState);
        }
        System.out.println((player == 'x') ? "Spieler 1" : "Spieler 2" + " hat gewonnen!");
    }
}
