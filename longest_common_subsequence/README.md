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

This means that it would take 2<sup>n</sup> time to compute all the subsequences and an extra n time to find the largest subsequence resulting in a time complexity of **O(n * 2<sup>n</sup>)** for this approach.

The tabulated Dynamic programming approach basically saves the sub problems calculated solution into a lookup table and re-uses that value to avoid any re-calculations. This is seen here:


You can see that the total time taken is O(s1 * s2) and is considerably lesser than the previous approach.

