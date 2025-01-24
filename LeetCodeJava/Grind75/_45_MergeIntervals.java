package Grind75;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.*;
public class _45_MergeIntervals {

    public int[][] merge(int[][] intervals) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> {
            return a[0] - b[0];
        });
        for(int[] interval: intervals) {
           queue.offer(interval);
        }
        int[] start = queue.poll();
        List<int[]> result = new ArrayList<>();
        while(!queue.isEmpty()) {
            int[] temp = queue.poll();
            if(temp[0] <= start[1] && start[1] <= temp[1]) {
                start[1] = temp[1];
            } else if(temp[1] <= start[1]){
            }else {
                result.add(start);
                start = temp;
            }
        }
        result.add(start);
        int[][] resultArr = new int[result.size()][2];
        for(int i = 0; i < result.size(); i++) {
            resultArr[i] = result.get(i);
        }
        return resultArr;
    }
}
