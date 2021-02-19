/*  https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
    Given a string s of '(' , ')' and lowercase English characters. 
    Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) so that 
    the resulting parentheses string is valid and return any valid string.
    Formally, a parentheses string is valid if and only if:
      * It is the empty string, contains only lowercase characters, or
      * It can be written as AB (A concatenated with B), where A and B are valid strings, or
      * It can be written as (A), where A is a valid string.
    Example 1:
      Input: s = "lee(t(c)o)de)"
      Output: "lee(t(c)o)de"
      Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.
    Example 2:
      Input: s = "a)b(c)d"
      Output: "ab(c)d"
    Example 3:
      Input: s = "))(("
      Output: ""
      Explanation: An empty string is also valid.
*/
import java.util.*;

public class MinimumRemoveToMakeValidParentheses {
  public String minRemoveToMakeValid(String s) {
    char[] sarr = s.toCharArray();
    int open = 0;
    int close = 0;
    for(int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if(c == '(') {
        open += 1;
      }
      else if(c == ')') {
        close += 1;
        if(close > open) {
          sarr[i] = ' ';
          close -= 1;
        }
      }
    }
    open = 0;
    close = 0;
    for(int i = s.length() - 1; i >= 0 ; i--) {
      char c = s.charAt(i);
      if(c == ')') {
        close += 1;
      }
      else if(c == '(') {
        open += 1;
        if(open > close) {
          sarr[i] = ' ';
          open -= 1;
        }
      }
    }
    String result = "";
    for(char c: sarr) {
      if(c != ' ') {
        result += c;
      }
    }
    return result;
  }

  public static void main(String[] args) {
    MinimumRemoveToMakeValidParentheses obj = new MinimumRemoveToMakeValidParentheses();
    System.out.println(obj.minRemoveToMakeValid("lee(t(c)o)de)"));
    System.out.println(obj.minRemoveToMakeValid("a)b(c)d"));
    System.out.println(obj.minRemoveToMakeValid("))(("));
    System.out.println(obj.minRemoveToMakeValid("(a(b(c)d)"));
  }
}
