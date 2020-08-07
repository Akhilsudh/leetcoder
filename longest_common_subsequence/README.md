# Longest Common Subsequence Problem

This problem is a classic example of Dynamic programming. We are first given two strings and are asked the length of the largest subsequence( a subsequence the sequence of character that occur not necessarily consecutive). for example:

```
Given two Strings:

str1 = "ABCDEFGHIJK" with length s1 = 11
str2 = "AZBYCXDWEVF" with length s2 = 11

The largest common subsequence is "ABCDEF"
```

The brute force approach to this is by finding all the possible ways of creating subsequences. Through combination we can say that the number of subsequences from a string of n character with one character would be nC1 and this can be expanded to n characters and that would be:

![CombinationImage](https://latex.codecogs.com/gif.latex?\binom{n}{0}&plus;\binom{n}{1}&plus;\binom{n}{2}&plus;...&plus;\binom{n}{n}&space;=&space;2^n)

This means that it would take 2<sup>n</sup> time to compute all the subsequences and an extra n time to find the largest subsequence resulting in a time complexity of **O(n * 2<sup>n</sup>)** for this approach. To find this programmatically consider the following cases:
1. If either one of the strings is empty (s1 = 0 or s2 = 0) then the length of the common subsequence is 0
2. If the last characters of both the substring are equal then we add one to the largest common subsequences.
![LCS base case](https://latex.codecogs.com/gif.latex?\dpi{200}&space;\tiny&space;LCS(str1(0...s1-1),str2(0...s2-1))=LCS(str1(0...s1-2),str2(0...s2-2))&plus;1)
3. If the last characters are not the same then we check compare the last character of one with the second last character of the other substring and vice versa and take the max value of the two.
![LCS base case](https://latex.codecogs.com/gif.latex?\dpi{150}&space;\small&space;LCS(str1(0...s1-1),str2(0...s2-1))=MAX(LCS(str1(0...s1-1),str2(0...s2-2)),&space;LCS(str1(0...s1-2),str2(0...s2-1))))


A recursive implementation is seen shown below:
```java
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
```

The **Dynamic programming** approach basically saves the solutions to the sub problems into a lookup table and re-uses that value to avoid any re-calculations. This is seen here:

```java
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
```

You can see that the total time taken is **O(s1 * s2)** and is considerably lesser than the previous approach.

