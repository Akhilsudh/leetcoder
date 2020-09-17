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
        if(s.length() == t.length()) {
            char[] sArr = s.toCharArray();
            char[] tArr = t.toCharArray();
            Arrays.sort(sArr);
            Arrays.sort(tArr);
            return Arrays.equals(sArr, tArr);
        }
        return false;
    }
}

/*
    Another possible solution is to use a character array with the length of the number of characters and
    add the counter for each occurance of a charcter in the s string and then subtract the counter and 
    return false whenever a negative vaue is encountered return false else return true.
*/