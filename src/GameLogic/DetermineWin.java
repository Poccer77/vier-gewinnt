package GameLogic;

import java.util.HashMap;

public class DetermineWin {
    public char win(String lastPlaced, HashMap<String, Character> gameState) {
        for (int i = -1; i <= 2; i++) {
            String direction = lastPlaced;
            int l = 1;

            while (true){
                direction = Integer.parseInt(direction.substring(0, 1)) + (1 - (i / 2))  + Character.toString(direction.charAt(1) + (i - (i / 2)));

                if (gameState.get(direction) != gameState.get(lastPlaced) || !gameState.containsKey(direction))
                    break;

                l++;

                if (l == 4)
                    return gameState.get(lastPlaced);
            }

            direction = lastPlaced;
            while (true){
                direction = Integer.parseInt(direction.substring(0, 1)) - (1 - (i / 2)) + Character.toString(direction.charAt(1) - (i - (i / 2)));

                if (gameState.get(direction) != gameState.get(lastPlaced) || !gameState.containsKey(direction))
                    break;

                l++;

                if (l == 4)
                    return gameState.get(lastPlaced);
            }
        }

        for (String field : gameState.keySet()){
            if (gameState.get(field) == ' ') {
                return ' ';
            }
        }

        return 'd';
    }
}
