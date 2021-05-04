/*  Linkedin Series Easy
    Given a string, return the character that appears the maximum number of times in the string.
*/
import java.util.*;
public class MaxStringCount {
  public char getMaxCount(String s) {
    Map<Character, Integer> map = new HashMap<Character, Integer>();
    char[] sArr = s.toCharArray();
    int max = 0;
    char res = ' ';
    for(char c: sArr) {
      if(map.containsKey(c)) {
        map.put(c, map.get(c) + 1);
      }
      else {
        map.put(c, 1);
      }
      if(max < map.get(c)) {
        max = map.get(c);
        res = c;
      }
    }
    return res;
  }
  public static void main(String[] args) {
    MaxStringCount obj = new MaxStringCount();
    System.out.println(obj.getMaxCount("aaaaasscaaaaaaccbbbbbbbbss"));
  }
}
