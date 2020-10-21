/*  https://leetcode.com/problems/triangle/
    Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
    For example, given the following triangle
    [
         [2],
        [3,4],
       [6,5,7],
      [4,1,8,3]
    ]
    The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
*/
import java.util.*;
public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] dp = new int[triangle.size()];
        for(int i = triangle.size() - 1; i >= 0; i--) {
            List<Integer> list = triangle.get(i);
            if(i == triangle.size() - 1) {
                for(int j = 0; j < list.size(); j++) {
                    dp[j] = list.get(j);
                }
            }
            else {
                for(int j = 0; j < list.size(); j++) {
                    dp[j] = Math.min(dp[j], dp[j + 1]) + list.get(j);
                }
            }
        }
        return dp[0];
    }
}