/*  Linkedin Series Easy
    Given an array of strings, remove each string that is an anagram of an 
    earlier string, then return the remaining array in sorted order.
*/
import java.util.*;
public class SortedStringAnagram {
  public String[] sortArray(String[] words) {
    List<String> result = new ArrayList<String>();
    Set<String> set = new HashSet<String>();
    for(String word: words) {
      char[] wordArr = word.toCharArray();
      Arrays.sort(wordArr);
      String w = new String(wordArr);
      if(!set.contains(w)) {
        set.add(w);
        result.add(word);
      }
    }
    String[] resultArr = new String[result.size()];
    Arrays.sort(result.toArray(resultArr));
    return resultArr;
  }
  public static void main(String[] args) {
    SortedStringAnagram obj = new SortedStringAnagram();
    String[] testCase = new String[]{"sudh", "akil", "ilka", "udsh", "blah", "bash"};
    String[] res = obj.sortArray(testCase);
    System.out.print("[");
    for(String word: res) {
      System.out.print(word + " ");
    }
    System.out.println("]");
  }
}
