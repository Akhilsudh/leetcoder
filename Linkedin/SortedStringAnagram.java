package Linkedin;
/*
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
      String w = wordArr.toString();
      if(!set.contains(w)) {
        set.add(w);
        result.add(word);
      }
    }
    String[] resultArr = new String[result.size()];
    System.out.println(resultArr.toString());
    return result.toArray(resultArr);
  }
  public static void main(String[] args) {
    SortedStringAnagram obj = new SortedStringAnagram();
    String[] testCase = new String[]{"akhil", "likha", "nikki", "iikkn", "vish", "bash"};
    for(String word: testCase) {
      System.out.println("hello");
    }
    System.out.println(testCase.toString());
    String[] res = obj.sortArray(testCase);
    System.out.println(res.toString());
  }
}
