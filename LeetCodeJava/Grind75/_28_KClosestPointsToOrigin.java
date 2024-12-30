package Grind75;

import java.util.*;

public class _28_KClosestPointsToOrigin {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> {
            double difference = Math.sqrt(a[0]*a[0] + a[1]*a[1]) - Math.sqrt(b[0]*b[0] + b[1]*b[1]);
            if(difference < 0) {
                return -1;
            } else if(difference > 0) {
                return 1;
            }
            return 0;
        });
        for(int[] point: points) {
            queue.offer(point);
        }
        List<int[]> result = new ArrayList<>();
        while(!queue.isEmpty() && k > 0) {
            k--;
            result.add(queue.remove());
        }
        return result.toArray(new int[result.size()][2]);
    }

    public static void main(String[] args) {
        _28_KClosestPointsToOrigin obj = new _28_KClosestPointsToOrigin();
        int[][] points1 = {new int[] {1, 3}, new int[] {-2, 2}};
        int[][] result1 = obj.kClosest(points1, 1);
        System.out.println(Arrays.deepToString(result1));
    }
}
