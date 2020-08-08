package catalan_number;

public class CatalanNumber {
    static int getNCatalanNumber(int N) {
        int[] catalan = new int[N + 1];
        catalan[0] = 1;
        for(int i = 1; i <= N; i++) {
            for(int j = 0; j < i; j++) {
                catalan[i] += catalan[j] * catalan[(i - 1) - j];
            }
        }
        return catalan[N];
    }

    public static void main(String args[]) {
        System.out.println("The first 5 Catalan numbers are : ");
        for(int i = 0; i < 5; i++) {
            System.out.print(getNCatalanNumber(i) + " ");
        }
        System.out.println();
        System.out.println("The 7th Catalan number is = " + getNCatalanNumber(6));
        System.out.println("The 10th Catalan number is = " + getNCatalanNumber(9));
    }
}