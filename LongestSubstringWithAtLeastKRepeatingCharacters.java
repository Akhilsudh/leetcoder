/*  https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/
    Given a string s and an integer k, return the length of the longest substring of s such that the 
    frequency of each character in this substring is greater than or equal to k.

    Example 1:
      Input: s = "aaabb", k = 3
      Output: 3
      Explanation: The longest substring is "aaa", as 'a' is repeated 3 times.

    Example 2:
      Input: s = "ababbc", k = 2
      Output: 5
      Explanation: The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.

    Constraints:
      1 <= s.length <= 104
      s consists of only lowercase English letters.
      1 <= k <= 105
*/
import java.util.*;
public class LongestSubstringWithAtLeastKRepeatingCharacters {
  public int longestSubstring(String s, int k) {
    char[] c = s.toCharArray();
    return recurse(c, k);
  }

  private int recurse(char[] s, int k) {
    if (s.length < k) {
      return 0;
    }
    Map<Character, Integer> letterCount = new HashMap<Character, Integer>();
    for (int i = 0; i < s.length; i++) {
      if (!letterCount.containsKey(s[i])) {
        letterCount.put(s[i], 1);
      } else {
        letterCount.put(s[i], letterCount.get(s[i]) + 1);
      }
    }
    for (int i = 0; i < s.length; i++) {
      if (letterCount.get(s[i]) >= k) {
        continue;
      } else {
        letterCount = null;
        return Math.max(recurse(Arrays.copyOfRange(s, 0, i), k), recurse(Arrays.copyOfRange(s, i + 1, s.length), k));
      }
    }
    return s.length;
  }
  public static void main(String[] args) {
    LongestSubstringWithAtLeastKRepeatingCharacters obj = new LongestSubstringWithAtLeastKRepeatingCharacters();
    System.out.println(obj.longestSubstring("aaabb", 3));
    System.out.println(obj.longestSubstring("ababbc", 2));
  }
}
