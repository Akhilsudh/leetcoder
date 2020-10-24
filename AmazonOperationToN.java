/*
    Given a positive integer N, and a starting point 1 one can perform 
    any of the following 2 operations in one step:
        Add 1 to the number
        Double the number
    Find the minimum number of operations to reach that value
*/
public class AmazonOperationToN {
    public int minimumPath(int N, int start) {
        if(start >= N) {
            return 0;
        }
        int count = 0;
        count = recurse(N, start, count);
        return count;
    }
    private int recurse(int N, int temp ,int count) {
        if(N == temp) {
            return count;
        }
        else {
            int path1 = (temp + 1 <= N) ? recurse(N, temp + 1, count + 1) : Integer.MAX_VALUE;
            int path2 = (temp * 2 <= N && temp > 0) ? recurse(N, temp * 2, count + 1) : Integer.MAX_VALUE;
            return Math.min(path1, path2);
        }
    }
    public static void main(String[] args) {
        AmazonOperationToN obj = new AmazonOperationToN();
        System.out.println(obj.minimumPath(5, 2));
        System.out.println(obj.minimumPath(5, 5));
        System.out.println(obj.minimumPath(10, 0));
    }
}
