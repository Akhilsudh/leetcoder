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
        Map<String, List<String>> results= new HashMap<String, List<String>>();
        for(String word: strs) {
            char[] keyArr = word.toCharArray();
            Arrays.sort(keyArr);
            String key = keyArr.toString();
            if(!results.containsKey(key)) {
                List<String> list = new ArrayList<String>();
                list.add(word);
                results.put(key, list);
                continue;
            }
            results.get(key).add(word);
        }
        return new ArrayList<List<String>>(results.values());
    }
}

/*  An alternate solution that I found online (Using prime numbers as factors for one of each character) further reducing
    time for converting back to string.
     __________________________________________________________________________________________________________________
    |   import java.util.*;                                                                                            |
    |   public class GroupAnagrams {                                                                                   |
    |       static long [] primes = {2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97,101};      |
    |                                                                                                                  |
    |       long getEncoding(String s) {                                                                               |
    |           char[] stringChars = s.toCharArray();                                                                  |
    |           long hashCode = 1;                                                                                     |
    |           for (char c : stringChars) {                                                                           |
    |               hashCode *= primes[c - 'a'];                                                                       |
    |           }                                                                                                      |
    |           return hashCode;                                                                                       |
    |       }                                                                                                          |
    |                                                                                                                  |
    |       public List<List<String>> groupAnagrams(String[] strs) {                                                   |
    |           Map<Long, List<String>> anagrams = new HashMap<>();                                                    |
    |           List<List<String>> result = new ArrayList<>();                                                         |
    |                                                                                                                  |
    |           for (String str: strs) {                                                                               |
    |               long encoding = getEncoding(str);                                                                  |
    |               if(anagrams.containsKey(encoding)) {                                                               |
    |                   anagrams.get(encoding).add(str);                                                               |
    |               }                                                                                                  |
    |               else {                                                                                             |
    |                   List<String> l = new ArrayList<>();                                                            |
    |                   l.add(str);                                                                                    |
    |                   result.add(l);                                                                                 |
    |                   anagrams.put(encoding, l);                                                                     |
    |               }                                                                                                  |
    |           }                                                                                                      |
    |                                                                                                                  |
    |           return result;                                                                                         |
    |       }                                                                                                          |
    |   }                                                                                                              |
    |__________________________________________________________________________________________________________________|
*/