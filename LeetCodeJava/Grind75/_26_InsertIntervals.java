package Grind75;

import java.util.*;

// [1,2],[3,5],[6,7],[8,10],[12,16]
public class _26_InsertIntervals {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int i = 0;
        while(i < intervals.length && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }
        while(i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        result.add(newInterval);
        while(i < intervals.length) {
            result.add(intervals[i]);
            i++;
        }
        return result.toArray(new int[result.size()][2]);
    }
}
