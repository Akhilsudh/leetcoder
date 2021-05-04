public class TilingProblemDP {
    static int numberOfWays(int n, int m) {
        int[] lookupTable = new int[n + 1];
        lookupTable[0] = 0;
        for(int i = 0; i <= n; i++) {
            if (i == 1 || i < m) {
                lookupTable[i] = 1;
            }
            else if(i == m) {
                lookupTable[i] = 2;
            }
            else {
                lookupTable[i] = lookupTable[i - 1] + lookupTable[i - m];
            }
        }
        return lookupTable[n];
    }

    public static void main(String args[]) {
        System.out.println(numberOfWays(3, 2));
        System.out.println(numberOfWays(5, 2));
        System.out.println(numberOfWays(3, 3));
        System.out.println(numberOfWays(1, 3));
    }
}