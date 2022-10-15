package GameLogic;

import java.util.HashMap;

public class DetermineWin {

    public static char win(String lastPlaced, HashMap<String, Character> gameState) {

        for (int i = -1; i <= 2; i++){
            String direction = Integer.toString(Integer.parseInt(lastPlaced.substring(0, 1)) + (1 - (i / 2))) + (lastPlaced.charAt(1) + (i - (i / 2)));
            int l = 1;
            for (;l <= 4; l++){
                if (gameState.get(direction) != gameState.get(lastPlaced) || !gameState.containsKey(direction)) break;
                else direction = Integer.toString(Integer.parseInt(direction.substring(0, 1)) + (1 - (i / 2))  + (direction.charAt(1) + (i - (i / 2))));
                if (l == 4) return gameState.get(lastPlaced);
            }
            direction = Integer.toString(Integer.parseInt(lastPlaced.substring(0, 1)) - (1 - (i / 2))) + (lastPlaced.charAt(1) - (i - (i / 2)));
            for (;l <= 4; l++){
                if (gameState.get(direction) != gameState.get(lastPlaced) || !gameState.containsKey(direction)) break;
                else direction = Integer.toString(Integer.parseInt(direction.substring(0, 1)) - (1 - (i / 2))  + (direction.charAt(1) - (i - (i / 2))));
                if (l == 4) return gameState.get(lastPlaced);
            }

        }
        char draw = 'd';
        for (String field : gameState.keySet()){

        }
        return ' ';
    }
}
