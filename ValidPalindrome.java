/*
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Example 1:
Input: "A man, a plan, a canal: Panama"
Output: true

Example 2:
Input: "race a car"
Output: false
*/

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        int j = s.length() - 1;
        int i = 0;
        while(i < j) {
            if(!Character.isLetterOrDigit(s.charAt(i))) {
                i++;
                continue;
            }
            if(!Character.isLetterOrDigit(s.charAt(j))) {
                j--;
                continue;
            }
            if(!(Character.toLowerCase(s.charAt(i)) == Character.toLowerCase(s.charAt(j)))){
                return false;
            }
            else {
                i++;
                j--;
            }
        }
        return true;
    }
}