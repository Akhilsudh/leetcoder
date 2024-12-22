package Grind75;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class _2_ValidParanthesis {
    public boolean isValid(String s) {
        Stack<Character> bracketStack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char bracket = s.charAt(i);
            if(bracket == '[' || bracket == '{' || bracket == '(') {
                bracketStack.push(s.charAt(i));
            } else if(bracket == ']' || bracket == '}' || bracket == ')') {
                if(!bracketStack.isEmpty() && (
                    (bracketStack.peek() == '[' && bracket == ']') ||
                    (bracketStack.peek() == '(' && bracket == ')') ||
                    (bracketStack.peek() == '{' && bracket == '}'))
                ) {
                    bracketStack.pop();
                } else {
                    return false;
                }
            }
        }
        return bracketStack.isEmpty();
    }

    public static void main(String[] args) {
        _2_ValidParanthesis obj = new _2_ValidParanthesis();
        System.out.println(obj.isValid("()"));
        System.out.println(obj.isValid("()[]{}"));
        System.out.println(obj.isValid("(]"));
        System.out.println(obj.isValid("([])"));
        System.out.println(obj.isValid("("));
        System.out.println(obj.isValid("]"));
    }
}
