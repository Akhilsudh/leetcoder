package Grind75;

import java.util.Stack;

public class _33_EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        char[] operators = {'+', '-', '*', '/'};
        for(int i = 0; i < tokens.length; i++) {
            int a, b;
            switch (tokens[i]){
                case "+":
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a+b);
                    break;
                case "-":
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a-b);
                    break;
                case "*":
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a*b);
                    break;
                case "/":
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a/b);
                    break;
                default:
                    stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        _33_EvaluateReversePolishNotation obj = new _33_EvaluateReversePolishNotation();
        System.out.println(obj.evalRPN(new String[] {"2","1","+","3","*"}));
        System.out.println(obj.evalRPN(new String[]{"4","13","5","/","+"}));
        System.out.println(obj.evalRPN(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"}));
        System.out.println(obj.evalRPN(new String[]{"2"}));
    }
}
