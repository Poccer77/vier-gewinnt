package WindowHandler;

import java.io.IOException;
import java.util.HashMap;

public class ConsolePrinter {

    public static StringBuilder board =
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

    public static void build(HashMap<Integer, Character> placement) throws IOException {

        for (Integer field : placement.keySet()){
            if ((placement.get(field) == null)) board.setCharAt(field, ' ');
            else board.setCharAt(field, placement.get(field));
        }
        System.out.println(board);
    }

}
