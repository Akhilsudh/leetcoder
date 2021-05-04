/*  Linkedin Series Medium
    Given two strings , s and t, create a function that operates per the following rules :
      Find whether string s is divisibe by string t. 
      String s is divisible by string t if string can be concatenated some number of times to 
      obtain s. and if so find another smaller string that can be concatenated to get both the strings
*/
public class DivisibleString {
  public String isDivisible(String s, String t) {
    StringBuilder sb = new StringBuilder();
    int sLen = s.length();
    int tLen = t.length();
    if(sLen % tLen != 0) {
      return "";
    }
    while(sb.length() < s.length()) {
      sb.append(t);
    }
    if(!sb.toString().equals(s)) {
      return "";
    }
    for(int i = 1; i <= t.length(); i++) {
      sb = new StringBuilder();
      if(t.length() % i == 0) {
        String sub = t.substring(0, i);
        while(sb.length() < t.length()) {
          sb.append(sub);
        }
        if(sb.toString().equals(t)) {
          return sub;
        }
      }
    }
    return "";
  }
  public static void main(String args[]) {
    DivisibleString obj = new DivisibleString();
    System.out.println(obj.isDivisible("abbaabbaabbaabbaabbaabbaabbaabba", "abbaabba"));
  }
}
