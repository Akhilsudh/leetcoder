public class PalindromNumber {
    public boolean isPalindrome(int x) {
        if(x < 0) {
            return false;
        }
        int xCopy = x;
        int rev = 0;
        while(xCopy != 0) {
            rev = rev * 10 + xCopy % 10;
            xCopy /= 10;
        }
        return (rev == x)?true:false;
    }
}