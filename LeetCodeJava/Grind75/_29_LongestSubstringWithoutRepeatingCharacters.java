// Sliding window
package Grind75;

import java.util.*;

public class _29_LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        int l = 0;
        Set<Character> set = new HashSet<>();
        int result = 0;
        for(int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            while(set.contains(c)) {
                set.remove(s.charAt(l));
                l++;
            }
            set.add(c);
            result = Math.max(result, r - l + 1);
        }
        return result;
    }

//    public int lengthOfLongestSubstring(String s) {
//        Map<Character, Integer> map = new HashMap<>();
//        int result = 0;
//        int temp = 0;
//        int lastIndex = 0;
//        for(int i = 0; i < s.length(); i++) {
//            if(map.containsKey(s.charAt(i)) && map.get(s.charAt(i)) > lastIndex) {
//                lastIndex = map.get(s.charAt(i));
//                temp = temp - (lastIndex + 1);
//                map.remove(s.charAt(i));
//            }
//            map.put(s.charAt(i), i);
//            temp += 1;
//            result = Math.max(result, temp);
//        }
//        return result;
//    }

    public static void main(String[] args) {
        _29_LongestSubstringWithoutRepeatingCharacters obj = new _29_LongestSubstringWithoutRepeatingCharacters();

        System.out.println(obj.lengthOfLongestSubstring("tmmzuxt"));
        System.out.println(obj.lengthOfLongestSubstring("bbbbbbb"));
        System.out.println(obj.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(obj.lengthOfLongestSubstring("pwwkew"));
        System.out.println(obj.lengthOfLongestSubstring("dvdf"));
        System.out.println(obj.lengthOfLongestSubstring(" "));
        System.out.println(obj.lengthOfLongestSubstring(""));
    }
}
