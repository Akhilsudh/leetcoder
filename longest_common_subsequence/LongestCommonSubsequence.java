public class LongestCommonSubsequence {
    int getLongestCommonSubsequenceRecursive(String str1, String str2, int s1, int s2) {
        if(s1 == 0 || s2 == 0) {
            return 0;
        }
        else if(str1.charAt(s1-1) == str2.charAt(s2-1)) {
            return (1 + getLongestCommonSubsequenceRecursive(str1, str2, s1 - 1, s2 - 1));
        }
        else {
            return Math.max(getLongestCommonSubsequenceRecursive(str1, str2, s1, s2 - 1), getLongestCommonSubsequenceRecursive(str1, str2, s1 - 1, s2));
        }
    }

    int getLongestCommonSubsequenceTabulatedDP(String str1, String str2, int s1, int s2) {
        int[][] lookupTable = new int[s1 + 1][s2 + 1];
        for(int i = 0; i <= s1; i++) {
            for(int j = 0; j <= s2; j++) {
                if(i == 0 || j == 0){
                    lookupTable[i][j] = 0;
                }
                else if(str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    lookupTable[i][j] = 1 + lookupTable[i - 1][j - 1];
                }
                else {
                    lookupTable[i][j] = Math.max(lookupTable[i][j - 1], lookupTable[i - 1][j]);
                }
            }
        }
        return lookupTable[s1][s2];
    }

    public static void main(String args[]) {
        String str1 = "ABCDEFGHIJK";
        String str2 = "AZBYCXDWEVF";
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        System.out.println(lcs.getLongestCommonSubsequenceRecursive(str1, str2, str1.length(), str2.length()));
        System.out.println(lcs.getLongestCommonSubsequenceTabulatedDP(str1, str2, str1.length(), str2.length()));
    }
}