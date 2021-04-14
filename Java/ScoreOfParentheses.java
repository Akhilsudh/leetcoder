/*  https://leetcode.com/problems/score-of-parentheses/
    Given a balanced parentheses string S, compute the score of the string based on the following rule:
      * () has score 1
      * AB has score A + B, where A and B are balanced parentheses strings.
      * (A) has score 2 * A, where A is a balanced parentheses string.

*/
public class ScoreOfParentheses {
  public int scoreOfParentheses(String S) {
    int deapth = 0;
    int result = 0;
    boolean flag = false;
    for(int i = 0; i < S.length(); i++) {
      if(S.charAt(i) == '(') {
        deapth += 1;
        flag = true;
      }
      else {
        if(flag) {
          result += 1 << (deapth - 1);
        }
        flag = false;
        deapth -= 1;
      }
    }
    return result;
  }

  public static void main(String[] args) {
    ScoreOfParentheses obj = new ScoreOfParentheses();
    System.out.println("The score of () = " + obj.scoreOfParentheses("()"));
    System.out.println("The score of (()) = " + obj.scoreOfParentheses("(())"));
    System.out.println("The score of ()() = " + obj.scoreOfParentheses("()()"));
    System.out.println("The score of (()(())) = " + obj.scoreOfParentheses("(()(()))"));
  }
}
