/*  https://leetcode.com/problems/group-anagrams/
    Given an array of strings strs, group the anagrams together. You can return the answer in any order.
    An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

    Example 1:
    Input: strs = ["eat","tea","tan","ate","nat","bat"]
    Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

    Example 2:
    Input: strs = [""]
    Output: [[""]]

    Example 3:
    Input: strs = ["a"]
    Output: [["a"]]

    Constraints:
        1 <= strs.length <= 104
        0 <= strs[i].length <= 100
        strs[i] consists of lower-case English letters.
*/

import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        boolean[] flag = new boolean[strs.length];
        List<List<String>> results = new ArrayList<List<String>>();
        for(int i = 0; i < strs.length; i++) {
            if(flag[i] == true) {
                continue;
            }
            flag[i] = true;
            List<String> result = new ArrayList<String>();
            Map<Character, Integer> temp1 = new HashMap<Character, Integer>();
            int m = strs[i].length();
            for(int k = 0; k < m; k++) {
                if(!temp1.containsKey(strs[i].charAt(k))) {
                    temp1.put(strs[i].charAt(k), 1);
                    continue;
                }
                temp1.put(strs[i].charAt(k), temp1.get(strs[i].charAt(k)) + 1);
            }
            result.add(strs[i]);
            for(int j = i + 1; j < strs.length; j++) {
                if(flag[j] == true) {
                    continue;
                }
                Map<Character, Integer> temp2 = new HashMap<Character, Integer>();
                int n = strs[j].length();
                for(int k = 0; k < n; k++) {
                    if(!temp2.containsKey(strs[j].charAt(k))) {
                        temp2.put(strs[j].charAt(k), 1);
                        continue;
                    }
                    temp2.put(strs[j].charAt(k), temp2.get(strs[j].charAt(k)) + 1);
                }
                if(temp2.equals(temp1)) {
                    flag[j] = true;
                    result.add(strs[j]);
                }
            }
            results.add(result);
        }
        return results;
    }
}