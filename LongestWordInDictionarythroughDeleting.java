/*  https://leetcode.com/problems/longest-word-in-dictionary-through-deleting/
    Given a string and a string dictionary, find the longest string in the dictionary 
    that can be formed by deleting some characters of the given string. If there are more than one possible results, 
    return the longest word with the smallest lexicographical order. If there is no possible result, return the empty string.

    Example 1:
      Input:
        s = "abpcplea", d = ["ale","apple","monkey","plea"]
      Output: 
        "apple"
*/
import java.util.*;

public class LongestWordInDictionarythroughDeleting {
  public String findLongestWord(String s, List<String> d) {
    String result = "";
    char[] sarr = s.toCharArray();
    for(String word: d) {
      char[] wordArr = word.toCharArray();
      int j = 0;
      if(wordArr.length < result.length() || word.equals(result)) {
        continue;
      }
      for(int i = 0; i < sarr.length; i++) {
        if(sarr[i] == wordArr[j]) {
          j += 1;
        }
        if(j == wordArr.length) {
          if((word.length() > result.length()) || ((word.length() == result.length()) && (word.compareTo(result) < 0))) {
            result = word;
          }
          break;
        }
      }
    }
    return result;
  }

  public static void main(String[] args) {
    LongestWordInDictionarythroughDeleting obj = new LongestWordInDictionarythroughDeleting();
    List<String> list = new ArrayList<String>();
    list.add("ale");
    list.add("apple");
    list.add("monkey");
    list.add("plea");
    String string = "abpcplea";
    System.out.println("Result for the list ['ale','apple','monkey','plea'] and string 'abpcplea' = " + obj.findLongestWord(string, list));
    list = new ArrayList<String>();
    list.add("a");
    list.add("b");
    list.add("c");
    list.add("d");
    System.out.println("Result for the list ['a','b','c','d'] and string 'abpcplea' = " + obj.findLongestWord(string, list));
  }
}