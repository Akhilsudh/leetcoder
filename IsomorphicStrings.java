/*  https://leetcode.com/problems/isomorphic-strings/
    Given two strings s and t, determine if they are isomorphic.
    Two strings are isomorphic if the characters in s can be replaced to get t.
    All occurrences of a character must be replaced with another character 
    while preserving the order of characters. No two characters may map to 
    the same character but a character may map to itself.

    Example 1:
        Input: s = "egg", t = "add"
        Output: true
    Example 2:
        Input: s = "foo", t = "bar"
        Output: false
    Example 3:
        Input: s = "paper", t = "title"
        Output: true
    Note: You may assume both s and t have the same length.
*/
import java.util.*;
public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        int[] sMap = new int[256];
        int[] tMap = new int[256];
        char c1, c2;
        for(int i = 0; i < s.length(); i++) {
            if(sMap[c1 = s.charAt(i)] != tMap[c2 = t.charAt(i)]) {
                return false;
            }
            sMap[c1] = i + 1;
            tMap[c2] = i + 1;
        }
        return true;
    }
}