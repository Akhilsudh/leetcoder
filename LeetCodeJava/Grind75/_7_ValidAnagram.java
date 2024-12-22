package Grind75;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class _7_ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();
        for(Character sc: s.toCharArray()) {
            sMap.computeIfAbsent(sc, k -> 0);
            sMap.put(sc, sMap.get(sc) + 1);
        }
        for(Character tc: t.toCharArray()) {
            tMap.computeIfAbsent(tc, k -> 0);
            tMap.put(tc, tMap.get(tc) + 1);
            if(sMap.get(tc) != null && sMap.get(tc) < tMap.get(tc)) {
                return false;
            }
        }
        if(sMap.size() != tMap.size()) {
            return false;
        }
        for(Character key: sMap.keySet()) {
            if(!Objects.equals(sMap.get(key), tMap.get(key))) {
                return false;
            }
        }
        return true;
    }
}
