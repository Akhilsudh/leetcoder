import java.util.*;
public class MinimumRemoveToMakeValidParentheses {
  public String minRemoveToMakeValid(String s) {
    Map<Integer, Character> map = new HashMap<Integer, Character>();
    Stack<Integer> stack = new Stack<Integer>();
    String result = "";
    for(int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if(c == ')') {
        if(!stack.isEmpty()) {
          map.put(i, c);
          stack.pop();
        }
      }
      else if(c == '(') {
        stack.push(i);
        map.put(i, c);
      }
      else {
        map.put(i, c);
      }
    }
    while(!stack.isEmpty()) {
      map.remove(stack.pop());
    }
    System.out.println(map);
    for(int i = 0; i < s.length(); i++) {
      if(map.containsKey(i)) {
        result += map.get(i);
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
