import java.util.*;

public class LetterCombinationsOfAPhoneNumber {
    String [] phonePattern = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> results = new ArrayList<String>();

    public void backTrack(String numberPattern, String result) {
        if(numberPattern.length() == 0) {
            results.add(result);
            return;
        }
        else {
            String letters = phonePattern[numberPattern.charAt(0) - 50];
            for(int i = 0; i < letters.length(); i++) {
                backTrack(numberPattern.substring(1), result + letters.charAt(i));
            }
        }
    }

    public List<String> letterCombinations(String digits) {
        if (digits.length() > 0) {
            backTrack(digits, "");
        }
        return results;
    }

    public static void main(String args[]) {
        LetterCombinationsOfAPhoneNumber obj = new LetterCombinationsOfAPhoneNumber();
        obj.letterCombinations("2342");
        System.out.println(obj.results);
    }
}