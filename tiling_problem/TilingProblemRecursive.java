package tiling_problem;

public class TilingProblemRecursive {
    static int numberOfWays(int n, int m) {
        if(n == 1 || n < m) {
            return 1;
        }
        else if(n == m) {
            return 2;
        }
        else {
            return (numberOfWays(n - 1, m) + numberOfWays(n - m, m));
        }
    }

    public static void main(String args[]) {
        System.out.println(numberOfWays(3, 2));
        System.out.println(numberOfWays(5, 2));
        System.out.println(numberOfWays(3, 3));
        System.out.println(numberOfWays(1, 3));
    }
}