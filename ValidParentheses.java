public class ValidParentheses {
    public static boolean isValid(String s) {
        char[] expr = s.toCharArray();
        char[] stack = new char[expr.length];
        char c;
        int index = 0;
        int top = -1;
        while(index < expr.length) {
            c = expr[index];
            switch(c) {
                case '(':
                    top++;
                    stack[top] = c;
                    index++;
                    break;
                case '{':
                    top++;
                    stack[top] = c;
                    index++;
                    break;
                case '[':
                    top++;
                    stack[top] = c;
                    index++;
                    break;
                case ')':
                    if(top == -1 || stack[top] != '(') {
                        return false;
                    }
                    stack[top] = '\0';
                    top--;
                    index++;
                    break;
                case '}':
                    if(top == -1 || stack[top] != '{') {
                        return false;
                    }
                    stack[top] = '\0';
                    top--;
                    index++;
                    break;
                case ']':
                    if(top == -1 || stack[top] != '[') {
                        return false;
                    }
                    stack[top] = '\0';
                    top--;
                    index++;
                    break;
            }
        }
        return (top == -1)?true:false;
    }
    public static void main(String args[]) {
        System.out.println("The validity of the parenthesis pattern '()' is " + Boolean.toString(isValid("()")));
        System.out.println("The validity of the parenthesis pattern '()[]{}' is " + Boolean.toString(isValid("()[]{}")));
        System.out.println("The validity of the parenthesis pattern '(]' is " + Boolean.toString(isValid("(]")));
        System.out.println("The validity of the parenthesis pattern '([)]' is " + Boolean.toString(isValid("([)]")));
        System.out.println("The validity of the parenthesis pattern '{[]}' is " + Boolean.toString(isValid("{[]}")));
        System.out.println("The validity of the parenthesis pattern ']})({[' is " + Boolean.toString(isValid("]})({[")));
        System.out.println("The validity of the parenthesis pattern '{{{[]([])}}[[{}]({})]}' is " + Boolean.toString(isValid("{{{[]([])}}[[{}]({})]}")));
    }
}