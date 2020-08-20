public class LongestValidParentheses {
    public static int longestValidParentheses(String s) {
        char[] string = s.toCharArray();
        int length = string.length;
        int max = 0;
        int[] lookupTable = new int[length];
        for(int i = 1; i < length; i++) {
            if(string[i] == ')') {
                if(string[i - 1] == '(') {
                    lookupTable[i] += 2;
                    if(i > 1) {
                        lookupTable[i] += lookupTable[i - 2];
                    }
                }
                else if(i - lookupTable[i - 1] > 0 && string[i - lookupTable[i - 1] - 1] == '(') {
                    lookupTable[i] = lookupTable[i - 1] + 2;
                    if(i - lookupTable[i - 1] > 1) {
                       lookupTable[i] += lookupTable[i - lookupTable[i - 1] - 2];
                    }
                }
            }
            max = Math.max(lookupTable[i], max);
        }
        return max;
    }

    public static void main(String args[]) {
        System.out.println(longestValidParentheses("()"));
        System.out.println(longestValidParentheses(")()(()))"));
        System.out.println(longestValidParentheses("))(("));
    }
}