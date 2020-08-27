import java.util.Map;
import java.util.TreeMap;

public class FindRightInterval {
    public int[] findRightInterval(int[][] intervals) {
        int[] result = new int[intervals.length];
        TreeMap<Integer, Integer> rightIntervalStartValueIndex = new TreeMap<Integer, Integer>();
        for(int i = 0; i < intervals.length; i++) {
            rightIntervalStartValueIndex.put(intervals[i][0], i);
            result[i] = -1;
        }
        Integer key;
        for(int i = 0; i < intervals.length; i++) {
            key = rightIntervalStartValueIndex.ceilingKey(intervals[i][1]);
            if(key != null) {
                result[i] = rightIntervalStartValueIndex.get(key);
            }
        }
        return result;
    }
}