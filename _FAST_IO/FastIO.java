/* 
Just some practice with Buffered reader for faster IO compared to Scanner that I have been using for a while now 
*/
package _FAST_IO;

import java.io.*;
import java.util.StringTokenizer;

public class FastIO {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter 5 space separated Integers : ");

        // Collect an array of 5 Integers
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] intArr = new int[5];
        for(int i = 0; i < intArr.length; i++) {
            intArr[i] = Integer.parseInt(st.nextToken());
        }
        System.out.print("The collected array is : ");
        System.out.print("[ ");
        for(int num: intArr) {
            System.out.print(num + " ");
        }
        System.out.println("]");

        // Collect an array of 5 space Strings
        System.out.print("Enter 5 space separated Words : ");
        String[] wordArr = new String[5];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < wordArr.length; i++) {
            wordArr[i] = st.nextToken();
        }
        System.out.print("The collected array is : ");
        System.out.print("[ ");
        for(String word: wordArr) {
            System.out.print(word + " ");
        }
        System.out.println("]");

        // Collect a line of String;
        System.out.print("Enter a word : ");
        String word = br.readLine();
        System.out.print("Enter a word : " + word);

        // Collect 2 line separated integers
        System.out.println("Enter two integers one by one : ");
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        System.out.println("The value of the two integers are : " + a + " & " + b);

        // Collect an array of characters
        System.out.print("Enter 5 space separated characters : ");
        char[] charArr = new char[5];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < wordArr.length; i++) {
            charArr[i] = st.nextToken().charAt(0);
        }
        System.out.print("The collected array is : ");
        System.out.print("[ ");
        for(char character: charArr) {
            System.out.print(character + " ");
        }
        System.out.println("]");
    }
}
