import GameLogic.*;
import UI.ConsolePrinter;
import UI.InputHandler;
import UI.Translator;

import java.io.IOException;

public class Main {
    private static final String TEXT_UNENTSCHIEDEN = "Unentschieden";
    private static final String TEXT_GEWONNEN = "%s hat gewonnen";
    private static final String TEXT_SPIELER_1 = "Spieler 1";
    private static final String TEXT_SPIELER_2 = "Spieler 2";

    public static void main(String[] args) throws IOException {
        var consolePrinter = new ConsolePrinter();
        var translator = new Translator();
        var inputHandler = new InputHandler(translator, consolePrinter);

        var game = new Game(consolePrinter, translator, inputHandler);

        var gameResult = game.run();

        System.out.println(switch (gameResult) {
            case UNENTSCHIEDEN -> TEXT_UNENTSCHIEDEN;
            case SPIELER_1_GEWINNT -> String.format(TEXT_GEWONNEN, TEXT_SPIELER_1);
            case SPIELER_2_GEWINNT -> String.format(TEXT_GEWONNEN, TEXT_SPIELER_2);
        });
    }
}
