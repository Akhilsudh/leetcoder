
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
          if(word.length() > result.length()) {
            result = word;
          } 
          else if(word.length() == result.length() && word.compareTo(result) < 0) {
            result = word;
          }
          break;
        }
      }
    }
    return result;
  }
}