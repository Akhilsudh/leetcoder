/*  https://leetcode.com/problems/valid-anagram/
    Given two strings s and t , write a function to determine if t is an anagram of s.

    Example 1:
    Input: s = "anagram", t = "nagaram"
    Output: true

    Example 2:
    Input: s = "rat", t = "car"
    Output: false

    Note:
    You may assume the string contains only lowercase alphabets.

    Follow up:
    What if the inputs contain unicode characters? How would you adapt your solution to such case?
*/

import java.util.*;
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> sMap = new HashMap<Character, Integer>();
        Map<Character, Integer> tMap = new HashMap<Character, Integer>();
        if(s.length() == t.length()) {
            char[] sArr = s.toCharArray();
            char[] tArr = t.toCharArray();
            for(int i = 0; i < s.length(); i++) {
                if(!sMap.containsKey(sArr[i])) {
                    sMap.put(sArr[i], 1);
                }
                else {
                    sMap.put(sArr[i], sMap.get(sArr[i]) + 1);
                }
                if(!tMap.containsKey(tArr[i])) {
                    tMap.put(tArr[i], 1);
                }
                else {
                    tMap.put(tArr[i], tMap.get(tArr[i]) + 1);
                }
            }
            return sMap.equals(tMap);
        }
        return false;
    }
}
