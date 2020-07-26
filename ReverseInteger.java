public class ReverseInteger {
    public int reverse(int x) {
        boolean negative = false;
        if(x < 0){
            x = -x;
            negative = true;
        }
        int digit, rev = 0, prev = 0;
        while(x > 0) {
            digit = x % 10;
            rev = rev * 10 + digit;
            if((rev - digit)/10 != prev) {
                return 0;
            }
            prev = rev;
            x = x/10;
        }
        return (negative)?-rev:rev;
    }
}