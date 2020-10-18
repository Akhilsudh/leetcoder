import java.util.*;
public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] dp = new int[triangle.size()]; //= triangle.get(triangle.size() - 1).toArray();
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
    }
}
