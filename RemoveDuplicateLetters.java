/*  https://leetcode.com/problems/remove-duplicate-letters/
    Given a string s, remove duplicate letters so that every letter appears once and only once. You must make sure your result is the smallest in lexicographical order among all possible results.
    Note: This question is the same as 1081: https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/

    Example 1:
        Input: s = "bcabc"
        Output: "abc"

    Example 2:
        Input: s = "cbacdcbc"
        Output: "acdb"

    Constraints:
        1 <= s.length <= 104
        s consists of lowercase English letters.
*/
import java.util.*;
public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        String res = "";
        Map<Character, Integer> lastPosMap = new HashMap<Character, Integer>();
        Map<Character, Boolean> seenMap = new HashMap<Character, Boolean>();
        for(int i = 0; i < s.length(); i++) {
           lastPosMap.put(s.charAt(i), i);
           seenMap.put(s.charAt(i), false);
        }
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(seenMap.get(c) == true) continue;
            while(!stack.isEmpty() && stack.peek() > c && i < lastPosMap.get(stack.peek())) {
                seenMap.put(stack.pop(), false);
            }
            stack.push(c);
            seenMap.put(c, true);
        }
        for(char c: stack) {
            res = res + c;
        }
        return res;
    }

    public static void main(String[] args) {
        RemoveDuplicateLetters obj = new RemoveDuplicateLetters();
        System.out.println(obj.removeDuplicateLetters("bcabc"));
        System.out.println(obj.removeDuplicateLetters("cbacdcbc"));
    }
}
