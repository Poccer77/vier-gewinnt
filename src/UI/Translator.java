package UI;

import com.google.common.collect.HashBiMap;

import java.util.HashMap;

public class Translator {
    private final HashBiMap<String, Integer> indexPositionMapping;

    private HashBiMap<String, Integer> translator() {
        HashBiMap<String, Integer> t = HashBiMap.create();

        int startField = 60;

        for (int i = 0; i < 7; i++) {
            int field = startField;
            for (char l = 'A'; l <= 'F'; l++) {
                t.put((Integer.toString(i) + l), field);
                field += 60;
            }
            startField += 4;
        }

        return t;
    }

    public Translator() {
        indexPositionMapping = translator();
    }

    public HashBiMap<String, Integer> getMapping() {
        return indexPositionMapping;
    }

    public HashMap<Integer, Character> draw(HashBiMap<String, Integer> translation, HashMap<String, Character> gameState) {
        HashMap<Integer, Character> translatedState = new HashMap<>();

        for(String field : gameState.keySet()){
            translatedState.put(translation.get(field), gameState.get(field));
        }

        return translatedState;
    }

    public HashMap<String, Character> read(String board, HashBiMap<String, Integer> translation) {
        HashMap<String, Character> GameState = new HashMap<>();

        for (String field : translation.keySet()) {
            GameState.put(field, board.charAt(translation.get(field)));
        }

        return GameState;
    }
}
