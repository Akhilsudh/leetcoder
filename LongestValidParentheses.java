public class LongestValidParentheses {
    public static int longestValidParentheses(String s) {
        int length = s.length();
        int max = 0;
        int[] lookupTable = new int[length];
        for(int i = 0; i < length; i++) {
            if(s.charAt(i) == ')' && i > 0) {
                if(s.charAt(i - 1) == '(') {
                    lookupTable[i] += 2;
                    if(i >= 2) {
                        lookupTable[i] += lookupTable[i - 2];
                    }
                }
                else if(i - lookupTable[i - 1] >= 1 && s.charAt(i - lookupTable[i - 1] - 1) == '(') {
                    lookupTable[i] = lookupTable[i - 1] + 2;
                    if(i - lookupTable[i - 1] >= 2) {
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
    }
}