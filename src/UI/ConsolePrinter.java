package UI;

import java.util.HashMap;

public class ConsolePrinter {
    private StringBuilder board =
            new StringBuilder(
                    """      
                      1   2   3   4   5   6   7
                     --- --- --- --- --- --- ---\s
                    |   |   |   |   |   |   |   |
                     --- --- --- --- --- --- ---\s
                    |   |   |   |   |   |   |   |
                     --- --- --- --- --- --- ---\s
                    |   |   |   |   |   |   |   |
                     --- --- --- --- --- --- ---\s
                    |   |   |   |   |   |   |   |
                     --- --- --- --- --- --- ---\s
                    |   |   |   |   |   |   |   |
                     --- --- --- --- --- --- ---\s
                    |   |   |   |   |   |   |   |
                     --- --- --- --- --- --- ---\s
                    """);

    public void build(HashMap<Integer, Character> placement) {
        for (Integer field : placement.keySet()) {
            board.setCharAt(field, (placement.get(field) == null)
                ? ' '
                : placement.get(field));
        }

        System.out.println(board);
    }

    public String getBoard() {
        return board.toString();
    }
}
