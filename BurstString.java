/*  Burst String Problem
    Given a String with repeating characters and a burst length, output the string 
    such that count of some adjacent characters in string are less than burst length.
    Example 1:
        Input: abbccccdd, 3
        Output: abbdd
    Example 2:
        Input: abbcccdeaffff, 3
        Output: abbdea
*/

public class BurstString {
    public static String burst(String wordString, int count) {
        char[] word = wordString.toCharArray();
        String result = "";
        String burstString = "";
        char letter = 'a';
        int index = 0;
        for(int i = 0; i < word.length; i++) {
            if(i == 0) {
                letter = word[i];
                index += 1;
                burstString = burstString + word[i];
                continue;
            }
            
            if(word[i] == letter) {
                burstString = burstString + word[i];
                index += 1;
            }
            else if(word[i] != letter) {
                if(index < count) {
                    result = result + burstString;
                }
                letter = word[i];
                burstString = "" + letter;
                index = 1;
            }
            
            if (i == word.length - 1) {
                if(index < count) {
                    result = result + burstString;
                }
            }
        }
        return result;
    }

    public static void main(String args[]) {
        System.out.println(burst("abbccccdd", 3));
        System.out.println(burst("abbcccdeaffffb", 3));
    }
}
