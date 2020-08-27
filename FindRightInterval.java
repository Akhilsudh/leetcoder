public class FindRightInterval {
    public int[] findRightInterval(int[][] intervals) {
        int[] result = new int[intervals.length];
        int right, left, min, minj;
        for(int i = 0; i < intervals.length; i++){
            right = intervals[i][1];
            min = Integer.MAX_VALUE; 
            minj = -1;
            for(int j = 0; j < intervals.length; j++) {
                if(j == i) {
                    continue;
                }
                left = intervals[j][0];
                if((left - right > -1) && ((left - right) < min)) {
                    min = left - right;
                    minj = j;
                }
            }
            result[i] = minj;
        }
        return result;
    }
}