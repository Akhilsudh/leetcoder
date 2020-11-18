/*  https://leetcode.com/problems/merge-intervals/
    Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, 
    and return an array of the non-overlapping intervals that cover all the intervals in the input.

    Example 1:
      Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
      Output: [[1,6],[8,10],[15,18]]
      Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].

    Example 2:
      Input: intervals = [[1,4],[4,5]]
      Output: [[1,5]]
      Explanation: Intervals [1,4] and [4,5] are considered overlapping.
    
    Constraints:
      1 <= intervals.length <= 10^4
      intervals[i].length == 2
      0 <= starti <= endi <= 10^4
*/
import java.util.*;
public class MergeIntervals {
  public int[][] merge(int[][] intervals) {
    if(intervals.length == 1) {
      return intervals;
    }
    List<int[]> result = new ArrayList<int[]>();
    boolean flag = false;
    Arrays.sort(intervals, new java.util.Comparator<int[]>() {
      public int compare(int[] a, int[] b) {
        return Integer.compare(a[0], b[0]);
      }
    });
    for(int i = 0; i < intervals.length - 1; i++) {
      int start = intervals[i][0];
      int end = intervals[i][1];
      for(int j = i + 1; j < intervals.length; j++) {
        i = j-1;
        if(intervals[j][0] > end) {
          if(j == intervals.length - 1) {
            flag = true;
          }
          break;
        }
        end = Math.max(end, intervals[j][1]);
      }
      result.add(new int[] {start, end});
    }
    if(flag) {
      result.add(new int[] {intervals[intervals.length - 1][0], intervals[intervals.length - 1][1]});
    }
    int[][] results = new int[result.size()][2];
    for (int i =0; i < result.size(); i++) 
      results[i] = result.get(i);
    return results;
  }
  public static void main(String[] args) {
    MergeIntervals obj = new MergeIntervals();
    int[][] result1 = obj.merge(new int[][] {
      {1, 3},
      {2, 6},
      {8, 10},
      {10, 18}
    });
    for(int[] arr: result1) {
      System.out.println("{" + arr[0] + "," + arr[1] + "}");
    }
    
    int[][] result2 = obj.merge(new int[][] {
      {1, 4},
      {0, 2},
      {3, 5}
    });
    for(int[] arr: result2) {
      System.out.println("{" + arr[0] + "," + arr[1] + "}");
    }
  }
}
