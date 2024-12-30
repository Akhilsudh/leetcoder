package Grind75;

import java.util.*;

public class _17_LongestPalindrome {
    public int longestPalindrome(String s) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            frequencyMap.computeIfAbsent(s.charAt(i), k -> 0);
            frequencyMap.put(s.charAt(i), frequencyMap.get(s.charAt(i)) + 1);
        }
        int result = 0;
        for(Character c: frequencyMap.keySet()) {
            if(frequencyMap.get(c) % 2 == 0) {
                result += frequencyMap.get(c);
                frequencyMap.put(c, 0);
            } else if(frequencyMap.get(c) > 2) {
                result += frequencyMap.get(c) - 1;
                frequencyMap.put(c, 1);
            }
        }
        for(Character c: frequencyMap.keySet()) {
            if(frequencyMap.get(c) > 0) {
                result += 1;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        _17_LongestPalindrome obj = new _17_LongestPalindrome();
        System.out.println(obj.longestPalindrome("abccccdd"));
        System.out.println(obj.longestPalindrome("ab"));
        System.out.println(obj.longestPalindrome("a"));
    }
}
