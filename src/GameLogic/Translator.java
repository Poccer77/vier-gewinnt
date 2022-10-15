package GameLogic;

import com.google.common.collect.HashBiMap;

public class Translator {

    private static HashBiMap<String, Integer> translator(){

        HashBiMap<String, Integer> t = HashBiMap.create();
        int field = 60;

        for (int i = 0; i < 7; i++){
            for (char l = 'A'; l <= 'F'; l++){
                t.put((Integer.toString(i) + l), field);
                field += 4;
            }
            field += 32;
        }

        return t;
    }

    public static final HashBiMap<String, Integer> t = Translator.translator();
}
