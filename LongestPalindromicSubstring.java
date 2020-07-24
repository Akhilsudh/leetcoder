public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        boolean[][] palinFlag = new boolean[s.length()][s.length()];
        int i = 0, j = 0, k = 0;
        int maxLen = 0;
        int first = 0;
        while(i < s.length()) {
            palinFlag[i][i] = true;
            i++;
            maxLen = 1;
            
        }
        for(i = 0; i < s.length() - 1; i++) {
            if(s.charAt(i) == s.charAt(i+1)) {
                palinFlag[i][i+1] = true;
                if(maxLen < 2){
                    first = i;
                    maxLen = 2;
                }
            }
        }
        for(k = 2; k < s.length(); k++) {
            for(i = 0; i < s.length() - k; i++) {
                j = i + k;
                if(palinFlag[i+1][j-1] && (s.charAt(i) == s.charAt(j))) {
                    palinFlag[i][j] = true;
                    if(k + 1 > maxLen) {
                        maxLen = k + 1;
                        first = i;
                    }
                }
            }
        }
        if(maxLen == 0)
            return "";
        else if(maxLen == 1)
            return "" + s.charAt(0);
        return s.substring(first, first + maxLen);
    }
}