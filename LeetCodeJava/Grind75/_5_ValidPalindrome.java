package Grind75;

public class _5_ValidPalindrome {
    public boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;
        while (l <= r) {
            if(!Character.isLetterOrDigit(s.charAt(l))) {
                l++;
            } else if (!Character.isLetterOrDigit(s.charAt(r))) {
                r--;
            } else if(Character.toLowerCase(s.charAt(l)) == Character.toLowerCase(s.charAt(r))) {
                l++;
                r--;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        _5_ValidPalindrome obj = new _5_ValidPalindrome();
        System.out.println(obj.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(obj.isPalindrome("race a car"));
        System.out.println(obj.isPalindrome(" "));
    }
}
