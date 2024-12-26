package Grind75;

import java.util.*;

public class _15_RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> ransomMap = new HashMap<>();
        Map<Character, Integer> magazineMap = new HashMap<>();
        for(int i = 0; i < ransomNote.length(); i++) {
            ransomMap.computeIfAbsent(ransomNote.charAt(i), k -> 0);
            ransomMap.put(ransomNote.charAt(i), ransomMap.get(ransomNote.charAt(i)) + 1);
        }
        for(int i = 0; i < magazine.length(); i++) {
            magazineMap.computeIfAbsent(magazine.charAt(i), k -> 0);
            magazineMap.put(magazine.charAt(i), magazineMap.get(magazine.charAt(i)) + 1);
        }

        for(Character ransomLetter: ransomMap.keySet()) {
            while(ransomMap.get(ransomLetter) > 0) {
                if(!magazineMap.containsKey(ransomLetter) || magazineMap.get(ransomLetter) == 0) {
                    return false;
                }
                magazineMap.put(ransomLetter, magazineMap.get(ransomLetter) - 1);
                ransomMap.put(ransomLetter, ransomMap.get(ransomLetter) - 1);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        _15_RansomNote obj = new _15_RansomNote();
        System.out.println(obj.canConstruct("aa", "aab"));
        System.out.println(obj.canConstruct("aa", "b"));
        System.out.println(obj.canConstruct("aabaa", "aabaakaka"));
    }
}
