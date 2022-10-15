package GameLogic;

import com.google.common.collect.HashBiMap;

import java.util.HashMap;

public class FieldTranslator {

    public static HashMap<Integer, Character> draw(HashBiMap<String, Integer> translation, HashMap<String, Character> gameState){

        HashMap<Integer, Character> translatedState = new HashMap<>();

        for(String field : gameState.keySet()){
            translatedState.put(translation.get(field), gameState.get(field));
        }

        return translatedState;
    }

    public static HashMap<String, Character> read(StringBuilder board, HashBiMap<String, Integer> translation){

        HashMap<String, Character> GameState = new HashMap<>();

        for (String field : translation.keySet()){
            GameState.put(field, board.charAt(translation.get(field)));
        }

        return GameState;
    }
}
